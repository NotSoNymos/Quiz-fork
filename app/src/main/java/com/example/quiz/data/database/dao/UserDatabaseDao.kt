package com.example.quiz.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quiz.data.database.entity.UserEntity

@Dao
interface UserDatabaseDao {
    @Query("SELECT * FROM user_tbl")
    fun getUserInfo(): UserEntity

    @Query("SELECT * FROM user_tbl")
    suspend fun getUser(): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserInfo(userEntity: UserEntity)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserIfNotExists(user: UserEntity)
}