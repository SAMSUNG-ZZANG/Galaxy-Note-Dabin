package org.sopt.domain

import org.sopt.domain.entity.User

interface AuthRepository {
    fun getAll(): List<User>

    fun findPasswordById(id: String, password: String): Boolean

    fun insert(user: User)

    fun delete(user: User)
}
