package com.example.today.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ViewModelComponent::class)
class RxModule {

    @ViewModelScoped
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

}