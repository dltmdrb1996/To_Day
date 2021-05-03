package com.roh.idus.localweather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class MainScheduler
@Qualifier
annotation class IOScheduler

@Module
@InstallIn(SingletonComponent::class)
class SchedulerModule {

    @Singleton
    @MainScheduler
    @Provides
    fun provideMainScheduler() = AndroidSchedulers.mainThread()

    @Singleton
    @IOScheduler
    @Provides
    fun provideIOScheduler() = Schedulers.io()

}