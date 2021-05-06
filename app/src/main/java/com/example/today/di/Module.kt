package com.example.today.di

import android.content.Context
import androidx.room.Room
import com.example.today.data.db.datasource.LocalDataSource
import com.example.today.data.db.myDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Singleton
    @Provides
    fun provideMemoDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context.applicationContext, myDB::class.java, "Sample.db")
            .createFromAsset("database/Data.db")
            .build()

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton
    @Provides
    fun provideLocalDataSource(
        database: myDB,
        ioDispatcher: CoroutineDispatcher
    ): LocalDataSource {
        return LocalDataSource(
            database.DbDao(), ioDispatcher
        )
    }

}