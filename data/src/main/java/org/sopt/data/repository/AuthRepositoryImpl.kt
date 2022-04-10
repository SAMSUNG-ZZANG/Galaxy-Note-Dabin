package org.sopt.data.repository

import org.sopt.data.dao.UserDao
import org.sopt.data.entity.UserData
import org.sopt.domain.AuthRepository
import org.sopt.domain.entity.User
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val userDao: UserDao) : AuthRepository {
    override fun getAll(): List<User> = userDao.getAll().toUserList()

    override fun findPasswordById(id: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun insert(user: User) {
        userDao.insert(user.toUserData())
    }

    override fun delete(user: User) {
        userDao.delete(user.toUserData())
    }

    private fun UserData.toUser() = User(
        name = name,
        email = email,
        password = password
    )

    private fun List<UserData>.toUserList() = map { it.toUser() }

    private fun User.toUserData() = UserData(
        id = null,
        name = name,
        email = email,
        password = password
    )

    private fun List<User>.toUserDataList() = map { it.toUserData() }
}
