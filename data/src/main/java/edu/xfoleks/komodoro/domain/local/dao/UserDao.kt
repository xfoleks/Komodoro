package edu.xfoleks.komodoro.domain.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import edu.xfoleks.komodoro.domain.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun createUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE user_name = :userName")
    suspend fun getUser(userName: String): UserEntity

}