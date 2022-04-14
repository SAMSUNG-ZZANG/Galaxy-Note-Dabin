package org.sopt.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sopt.data.dao.UserDao
import org.sopt.data.entity.UserData

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}
