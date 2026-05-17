package com.example.quiz.presentation.screen.profile

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.data.model.Info
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleOutlinedText
import com.example.quiz.ui.theme.QuizTheme

@SuppressLint("SuspiciousIndentation")
@Composable
fun ContentProfileScreen(modifier: Modifier = Modifier, viewModel: ProfileViewModel = viewModel()) {

    val image by viewModel.image.collectAsState()
    val surname by viewModel.surname.collectAsState()
    val name by viewModel.name.collectAsState()
    val patronymic by viewModel.patronymic.collectAsState()
    val gender by viewModel.gender.collectAsState()
    val age by viewModel.age.collectAsState()
    val education by viewModel.education.collectAsState()
    val town by viewModel.town.collectAsState()

    val listInfo = listOf<Info>(
        Info(
            Modifier,
            surname,
            "Фамилия",
            viewModel::onSurnameChange,
            MaterialTheme.colorScheme.secondary
        ),
        Info(
            Modifier.padding(top = 15.dp),
            name,
            "Имя",
            viewModel::onNameChange,
            MaterialTheme.colorScheme.secondary
        ),
        Info(
            Modifier.padding(top = 15.dp),
            patronymic,
            "Отчество",
            viewModel::onPatrinymicChange,
            MaterialTheme.colorScheme.secondary
        ),
        Info(
            Modifier.padding(top = 15.dp),
            gender,
            "Пол",
            viewModel::onGenderChange,
            MaterialTheme.colorScheme.secondary
        ),
        Info(
            Modifier.padding(top = 15.dp),
            age,
            "Возраст",
            viewModel::onAgeChange,
            MaterialTheme.colorScheme.secondary
        ),
        Info(
            Modifier.padding(top = 15.dp),
            education,
            "Образование",
            viewModel::onEducationChange,
            MaterialTheme.colorScheme.secondary
        ),
        Info(
            Modifier.padding(top = 15.dp),
            town,
            "Город",
            viewModel::onTownChange,
            MaterialTheme.colorScheme.secondary
        )
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
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
            SimpleButton(modifier = Modifier.padding(top = 15.dp).width(368.dp), "Сохранить") { }
        }
        item{
            Spacer(Modifier.height(120.dp))
        }
    }
}

@Preview
@Composable
private fun ContentPreview() {
    QuizTheme { ContentProfileScreen() }
}