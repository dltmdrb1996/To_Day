package com.roh.idus.localweather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ActivityComponent::class)
class RxModule {

    @ActivityScoped
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

}