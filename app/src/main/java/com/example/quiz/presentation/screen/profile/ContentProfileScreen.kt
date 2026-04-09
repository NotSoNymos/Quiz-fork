package com.example.quiz.presentation.screen.profile

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.presentation.composables.SimpleOutlinedText

@Composable
fun ContentProfileScreen(modifier: Modifier = Modifier, viewModel: ProfileViewModel= viewModel()) {
    val image by viewModel.image.collectAsState()
    val surname by viewModel.surname.collectAsState()
    val name by viewModel.name.collectAsState()
    val patronymic by viewModel.patronymic.collectAsState()
    val gender by viewModel.gender.collectAsState()
    val age by viewModel.age.collectAsState()
    val education by viewModel.education.collectAsState()
    val town by viewModel.town.collectAsState()
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {


        SimpleOutlinedText(Modifier,surname,"Фамилия", viewModel::onSurnameChange)
        SimpleOutlinedText(Modifier.padding(top = 15.dp),name,"Имя", viewModel::onNameChange)
        SimpleOutlinedText(Modifier.padding(top = 15.dp),patronymic,"Отчество", viewModel::onPatrinymicChange)
        SimpleOutlinedText(Modifier.padding(top = 15.dp),gender,"Пол",viewModel::onGenderChange)
        SimpleOutlinedText(Modifier.padding(top = 15.dp),age,"Возраст", viewModel::onAgeChange)
        SimpleOutlinedText(Modifier.padding(top = 15.dp),education,"Образование", viewModel::onEducationChange)
        SimpleOutlinedText(Modifier.padding(top = 15.dp),town,"Город", viewModel::onTownChange)




    }
}

@Preview
@Composable
private fun ContentPreview() {
    ContentProfileScreen()
}