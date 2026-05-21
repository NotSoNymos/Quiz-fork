package com.example.quiz.presentation.screen.profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.data.model.Info
import com.example.quiz.presentation.composables.BackgroundProfile
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    ProfileScreenContent(
        modifier = modifier,
        uiState = uiState,
        onSubmitAction = { formState -> viewModel.submitFormState(formState) },
    )

}


@Composable
fun ProfileScreenContent(
    modifier: Modifier = Modifier,
    uiState: ProfileState,
    onSubmitAction: ((ProfileFormState) -> Unit) = {}
) {
    if (uiState.isLoading){
        CircularProgressIndicator(modifier = Modifier.size(32.dp))
        return
    }

    var formState by rememberSaveable {
        mutableStateOf(uiState.formState)
    }

    val listInfo = listOf(
        Info(
            Modifier,
            formState.surname,
            "Фамилия",
            { formState = formState.copy(surname = it) },
            MaterialTheme.colorScheme.secondary
        ), Info(
            Modifier.padding(top = 15.dp),
            formState.name,
            "Имя",
            { formState = formState.copy(name = it) },
            MaterialTheme.colorScheme.secondary
        ), Info(
            Modifier.padding(top = 15.dp),
            formState.patronymic,
            "Отчество",
            { formState = formState.copy(patronymic = it) },
            MaterialTheme.colorScheme.secondary
        ), Info(
            Modifier.padding(top = 15.dp),
            formState.gender,
            "Пол",
            { formState = formState.copy(gender = it) },
            MaterialTheme.colorScheme.secondary
        ), Info(
            Modifier.padding(top = 15.dp),
            formState.age,
            "Возраст",
            { formState = formState.copy(age = it) },
            MaterialTheme.colorScheme.secondary
        ), Info(
            Modifier.padding(top = 15.dp),
            formState.education,
            "Образование",
            { formState = formState.copy(education = it) },
            MaterialTheme.colorScheme.secondary
        ), Info(
            Modifier.padding(top = 15.dp),
            formState.town,
            "Город",
            { formState = formState.copy(town = it) },
            MaterialTheme.colorScheme.secondary
        )
    )

    BackgroundProfile(
        modifier = Modifier,
        icon = formState.image,
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(top = 5.dp)
        ) {
            items(
                items = listInfo,
            ) { info ->
                SimpleOutlinedText(
                    modifier = info.modifier,
                    text = info.text,
                    label = info.label,
                    onTextChange = info.onTextChange,
                    color = info.color,
                    shape = 20
                )
            }
            item {
                SimpleButton(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .width(368.dp), "Сохранить"
                ) { onSubmitAction.invoke(formState) }
            }
            item {
                Spacer(Modifier.height(120.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenContentPreview() {
    QuizTheme {
        ProfileScreenContent(
            modifier = Modifier,
            uiState = ProfileState(false)
        )
    }
}