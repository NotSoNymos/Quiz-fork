package com.example.quiz.data.repository

import com.example.quiz.data.database.dao.UserDatabaseDao
import com.example.quiz.data.database.entity.UserEntity
import com.example.quiz.data.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val _userDatabaseDao: UserDatabaseDao
) {
    suspend fun getUserInfo(): User {
        val response = _userDatabaseDao.getUser()

        return UserEntity.toUser(response)
    }

    suspend fun updateUserInfo(user: User) {
        val entity = UserEntity.fromUser(user)

        _userDatabaseDao.updateUserInfo(entity)
    }

    suspend fun insertUser(user: User){
        val entity = UserEntity.fromUser(user)

        _userDatabaseDao.insertUser(entity)
    }

    suspend fun deleteUser(user: User){
        val entity = UserEntity.fromUser(user)

        _userDatabaseDao.deleteUser(entity)
    }
}