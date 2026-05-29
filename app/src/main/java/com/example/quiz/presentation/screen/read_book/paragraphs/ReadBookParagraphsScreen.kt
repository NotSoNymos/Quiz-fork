package com.example.quiz.presentation.screen.read_book.paragraphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.ReadBookCard
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.presentation.navigation.Destinations
import com.example.quiz.presentation.screen.read_book.ReadBookViewModel
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun ReadBookParagraphsScreen(
    modifier: Modifier = Modifier,
    viewModel: ReadBookViewModel = hiltViewModel(),
    navHostController: NavHostController,
) {
    val state by viewModel.paragraphState.collectAsState()

    ReadBookParagraphsContent(
        modifier = modifier,
        uiState = state,
        onNavigateBackAction = { navHostController.popBackStack() },
        onIsLast= viewModel.isLast(),
        onNextPageAction = { viewModel.readNextPage() },
        navHostController=navHostController)
}
@Composable
fun ReadBookParagraphsContent(
    modifier: Modifier = Modifier,
    uiState: ReadBookParagraphsState,
    onNavigateBackAction: () -> Unit,
    onIsLast: Boolean,
    onNextPageAction: () -> Unit,
    navHostController: NavHostController
) {
    SimpleQuizBackground(
        modifier = modifier,
        label = "Чтение",
        type = "book",
        onNavigateBackAction = onNavigateBackAction
    )
    Column(
        modifier = Modifier
            .padding(top = 180.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReadBookCard(
            description = uiState.paragraphText, title = uiState.title
        )
        SimpleButton(
            Modifier.padding(top = 10.dp, start = 160.dp), if (onIsLast) "Завершить" else "Далее",
            onClick = {if (onIsLast) navHostController.navigate(Destinations.Profile) else onNextPageAction() }
        )
    }
}

//@Preview
//@Composable
//private fun ReadBookParagraphsContentScreenPreview() {
//    QuizTheme {
//        ReadBookParagraphsContent(
//            modifier = Modifier, uiState = ReadBookParagraphsState(
//                title = "Лукоморье", paragraphText = """
//                У лукоморья дуб зелёный;
//                Златая цепь на дубе том:
//                И днём и ночью кот учёный
//                Всё ходит по цепи кругом;
//                Идёт направо — песнь заводит,
//                Налево — сказку говорит.
//                Там чудеса: там леший бродит,
//                Русалка на ветвях сидит;
//                Там на неведомых дорожках
//                Следы невиданных зверей;
//                Избушка там на курьих ножках
//                Стоит без окон, без дверей;
//                Там лес и дол видений полны;
//                На брег песчаный и пустой,
//                И тридцать витязей прекрасных
//                Чредой из вод выходят ясных,
//                И с ними дядька их морской;
//            """.trimIndent()
//            ),
//            onNavigateBackAction = {},
//            onNextPageAction = {}.invoke()
//        )
//    }
//}