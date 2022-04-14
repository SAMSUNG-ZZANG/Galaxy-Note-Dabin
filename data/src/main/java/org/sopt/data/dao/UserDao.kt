package org.sopt.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.sopt.data.entity.UserData

@Dao
interface UserDao {
    @Query("SELECT * FROM user_data_table")
    fun getAll(): List<UserData>

    @Query("SELECT * FROM user_data_table WHERE email == :email")
    fun findPasswordById(email: String): UserData

    @Insert
    fun insert(userData: UserData)

    @Delete
    fun delete(userData: UserData)
}
