package com.example.today.di

import android.content.Context
import androidx.room.Room
import com.example.today.data.db.room.SaveDatabase
import com.example.today.data.db.room.SaveRepositoryImpl
import com.example.today.data.mapper.SaveMapper
import com.example.today.domain.repository.SaveRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): SaveDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            SaveDatabase::class.java,
            "save.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() : CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideSaveImpl(
        database: SaveDatabase,
        ioDispatcher: CoroutineDispatcher,
        saveMapper: SaveMapper
    ): SaveRepositoryImpl {
        return SaveRepositoryImpl(
            database.saveDao(), ioDispatcher , saveMapper
        )
    }

}