package com.example.quiz.presentation.screen.read_quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.data.model.Question
import com.example.quiz.data.model.Quiz
import com.example.quiz.domain.repository.DomainRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ReadQuizViewModel.Factory::class)
class ReadQuizViewModel @AssistedInject constructor(
    @Assisted private val quizId: String, private val _domainRepositoryImpl: DomainRepositoryImpl
): ViewModel() {
    private val _uiState = MutableStateFlow(ReadQuizState())
    val uiState = _uiState.asStateFlow()

    private var quizData = Quiz()
    private lateinit var currentQuestionIterator: Iterator<Question>
    private var currentQuestionIndex = 0

    private lateinit var savedQuestionsData: MutableList<Question>

    fun getQuizData() {
        viewModelScope.launch(Dispatchers.IO) {
            quizData = _domainRepositoryImpl.getQuizById(quizId)
            currentQuestionIterator = quizData.questions.iterator()

            _uiState.update {
                it.copy(
                    quizTitle = quizData.title,
                    quizDescription = quizData.description
                )
            }

            savedQuestionsData = quizData.questions.toMutableList()
        }
    }

    fun saveTempAnswers(): Boolean {
        if (uiState.value.isFirstPage || uiState.value.isLastPage)
            return true

        val currentAnswers = uiState.value.answerVariants
        val currentQuestionText = uiState.value.questionText

        if (currentAnswers.count { it.second } != 1) {
            return false
        }

        val answer = currentAnswers.filter { it.second }[0]

        savedQuestionsData[currentQuestionIndex] = Question(
            question = currentQuestionText,
            answer = answer.first,
            variableAnswers = currentAnswers.map { it.first }
        )

        currentQuestionIndex += 1

        return true
    }

    fun saveAllAnswers() {
        viewModelScope.launch(Dispatchers.IO) {
            val quizToSave = quizData.copy(questions = savedQuestionsData)

            _domainRepositoryImpl.updateQuiz(quizToSave)
        }
    }

    fun nextQuestion(onQuizCompleteAction: () -> Unit) {
        if (uiState.value.isLastPage) {
            onQuizCompleteAction.invoke()
            return
        }

        viewModelScope.launch(Dispatchers.IO) {

            if (!currentQuestionIterator.hasNext()) {
                saveAllAnswers()

                _uiState.update {
                    it.copy(
                        isFirstPage = false,
                        questionText = "Вопросы закончились!",
                        answerVariants = listOf(),
                        isLastPage = true
                    )
                }

                return@launch
            }

            if (!saveTempAnswers()) {
                //TODO: handle message - user should select only one answer!
                return@launch
            }

            val question = currentQuestionIterator.next()

            _uiState.update {
                it.copy(
                    isFirstPage = false,
                    answerVariants = question.variableAnswers.map { element ->
                        element to
                                (savedQuestionsData.getOrElse(currentQuestionIndex) { Question() }.answer == element) },
                    questionText = question.question,
                    isLastPage = false
                )
            }
        }
    }

    fun toggleAnswer(targetIndex: Int, value: Boolean) {
        _uiState.update {
            it.copy(
                answerVariants = it.answerVariants.mapIndexed { pairIndex, pair ->
                    if (pairIndex == targetIndex) pair.copy(
                        second = value
                    ) else pair
                })
        }
    }

    init {
        getQuizData()
    }

    @AssistedFactory
    interface Factory {
        fun create(quizId: String): ReadQuizViewModel
    }
}