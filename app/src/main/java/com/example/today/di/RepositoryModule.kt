package com.example.today.di

import com.example.today.data.weatherdata.repository.WeatherRepositoryImpl
import com.example.today.data.db.firebasedb.FirebaseRepositoryImpl
import com.example.today.data.db.room.SaveRepositoryImpl
import com.example.today.domain.repository.FireBaseRepository
import com.example.today.domain.repository.SaveRepository
import com.example.today.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @Singleton
    @Binds
    fun bindFirebaseRepository(impl : FirebaseRepositoryImpl): FireBaseRepository

    @Singleton
    @Binds
    fun bindSaveRepository(impl : SaveRepositoryImpl): SaveRepository

}

