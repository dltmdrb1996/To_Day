package com.example.today.di

import com.example.today.data.api.repository.WeatherRepositoryImpl
import com.example.today.data.db.firebasedb.FirebaseService
import com.example.today.domain.repository.FireBaseRepository
import com.example.today.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class FireBaseModule     {
//
//
//
//    @Singleton
//    @Binds
//    fun bindWeatherRepository(db : FirebaseService ) : FireBaseRepository
//
//
//
//}