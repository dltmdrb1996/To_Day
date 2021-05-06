package com.example.today.di

import android.content.Context
import androidx.room.Room
import com.example.today.data.api.datasource.WeatherDataSource
import com.example.today.data.api.datasource.WeatherRemoteDataSource
import com.example.today.data.db.datasource.LocalDataSource
import com.example.today.data.db.myDB
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