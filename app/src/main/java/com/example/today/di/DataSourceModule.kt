package com.example.today.di

import android.content.Context
import androidx.room.Room
import com.example.today.data.weatherdata.datasource.WeatherDataSource
import com.example.today.data.weatherdata.datasource.WeatherRemoteDataSource
import com.example.today.data.db.room.SaveDatabase
import com.example.today.data.db.room.SaveRepositoryImpl
import com.example.today.data.mapper.SaveMapper
import com.example.today.domain.repository.SaveRepository
import dagger.Binds
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
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindWeatherServerDataSource(impl: WeatherRemoteDataSource): WeatherDataSource

}