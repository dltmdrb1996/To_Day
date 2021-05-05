package com.example.today.di

import com.example.today.data.api.datasource.WeatherRemoteDataSource
import com.example.today.domain.usecase.SearchLocationWeathersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RxModule {

    @ViewModelScoped
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

}