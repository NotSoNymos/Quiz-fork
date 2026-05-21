package com.example.quiz.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quiz.data.model.User

@Entity(tableName = "user_tbl")
data class UserEntity(
    @PrimaryKey
    val email: String,
    val surname: String,
    val name: String,
    val patronymic: String,
    val gender: String,
    val age: String,
    val education: String ,
    val town: String,
) {
    companion object {
        fun fromUser(user: User): UserEntity {
            return UserEntity(
                email = "test",
                surname = user.surname,
                name = user.name,
                patronymic = user.patronymic,
                gender = user.gender,
                age = user.age,
                education = user.education,
                town = user.town
            )
        }
        fun toUser(userEntity: UserEntity): User{
            return User(
                surname = userEntity.surname,
                name = userEntity.name,
                patronymic = userEntity.patronymic,
                gender = userEntity.gender,
                age = userEntity.age,
                education = userEntity.education,
                town = userEntity.town
            )
        }
    }
}