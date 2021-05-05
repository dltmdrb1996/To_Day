package com.example.today.di

import com.example.today.data.api.datasource.WeatherDataSource
import com.example.today.data.api.datasource.WeatherRemoteDataSource
import com.example.today.domain.usecase.SearchLocationWeathersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindWeatherServerDataSource(impl: WeatherRemoteDataSource): WeatherDataSource


}