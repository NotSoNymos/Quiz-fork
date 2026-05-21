package com.example.quiz.presentation.screen.profile

import androidx.lifecycle.ViewModel
import com.example.quiz.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {
    private val _image = MutableStateFlow(R.drawable.ic_launcher_background)
    val image: StateFlow<Int> = _image

    private val _surname = MutableStateFlow("")
    val surname: StateFlow<String> = _surname

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _patronymic = MutableStateFlow("")
    val patronymic : StateFlow<String> = _patronymic

    private val _gender = MutableStateFlow("")
    val gender: StateFlow<String> = _gender

    private val _age = MutableStateFlow("")
    val age: StateFlow<String> = _age

    private val _education = MutableStateFlow("")
    val education: StateFlow<String> = _education

    private val _town = MutableStateFlow("")
    val town: StateFlow<String> = _town






    fun onImageChange(newImage: Int){
        _image.value = newImage
    }

    fun onNameChange(newName: String){
        _name.value = newName
    }

    fun onSurnameChange(newSurname: String){
        _surname.value = newSurname
    }

    fun onGenderChange(newGender: String){
        _gender.value = newGender
    }

    fun onAgeChange(newAge: String){
        _age.value = newAge
    }

    fun onEducationChange(newEducation: String){
        _education.value = newEducation
    }

    fun onTownChange(newTown: String){
        _town.value = newTown
    }
    fun onPatrinymicChange(newPatrinymic: String){
        _patronymic.value = newPatrinymic
    }



}