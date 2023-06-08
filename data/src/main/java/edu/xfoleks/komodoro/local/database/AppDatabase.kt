package edu.xfoleks.komodoro.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.xfoleks.komodoro.local.dao.UserDao
import edu.xfoleks.komodoro.local.entities.UserEntity

@Database(
    version = 1,
    entities = [
        UserEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}