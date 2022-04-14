package org.sopt.androidassignment.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.sopt.data.dao.UserDao
import org.sopt.data.database.UserDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java,
            "user database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao =
        database.userDao
}
