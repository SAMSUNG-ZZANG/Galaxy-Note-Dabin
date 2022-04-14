package org.sopt.androidassignment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.data.dao.UserDao
import org.sopt.data.repository.AuthRepositoryImpl
import org.sopt.domain.AuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun userRepo(
        userDao: UserDao
    ): AuthRepository = AuthRepositoryImpl(userDao)
}
