package com.example.quiz.presentation.screen.profile

import android.os.Parcelable
import com.example.quiz.R
import com.example.quiz.data.model.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileFormState(
    var image: Int = R.drawable.dog,
    var surname: String = "",
    var name: String = "",
    var patronymic: String = "",
    var gender: String = "",
    var age: String = "",
    var education: String = "",
    var town: String = "",
) : Parcelable {
    fun toUser(): User {
        return User(
            image = this.image,
            surname = this.surname,
            name = this.name,
            patronymic = this.patronymic,
            gender = this.gender,
            age = this.age,
            education = this.education,
            town = this.town,
        )
    }

    fun fromUser(user: User): ProfileFormState {
        image = user.image
        surname = user.surname
        name = user.name
        patronymic = user.patronymic
        gender = user.gender
        age = user.age
        education = user.education
        town = user.town

        return this
    }
}
