package edu.xfoleks.komodoro.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    indices = [
        Index("user_name", unique = true)
    ]
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "user_name", collate = ColumnInfo.NOCASE) val userName: String,
    val password: String
)
