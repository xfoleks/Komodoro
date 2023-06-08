package edu.xfoleks.komodoro.local.dao

import androidx.room.Dao
import androidx.room.Insert
import edu.xfoleks.komodoro.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun createUser(user: UserEntity)

}