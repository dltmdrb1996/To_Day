package com.example.today.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {




    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


}