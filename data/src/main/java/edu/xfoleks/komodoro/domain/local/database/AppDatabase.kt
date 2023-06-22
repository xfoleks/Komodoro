package edu.xfoleks.komodoro.domain.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.xfoleks.komodoro.domain.local.dao.UserDao
import edu.xfoleks.komodoro.domain.local.entities.UserEntity

@Database(
    version = 1,
    entities = [
        UserEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}