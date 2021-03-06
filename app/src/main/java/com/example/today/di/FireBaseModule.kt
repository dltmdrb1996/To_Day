package com.example.today.di

import com.example.today.data.db.firebasedb.FirebaseRepositoryImpl
import com.example.today.data.mapper.EngMapper
import com.example.today.data.mapper.MovieMapper
import com.example.today.data.mapper.MusicMapper
import com.example.today.util.NetworkHandler
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FireBaseModule {

    @Singleton
    @Provides
    fun providesDB(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun providesFirebase(
        firebaseFirestore: FirebaseFirestore,
        engMapper: EngMapper,
        movieMapper: MovieMapper,
        musicMapper: MusicMapper,
        networkHandler: NetworkHandler
    ): FirebaseRepositoryImpl = FirebaseRepositoryImpl(firebaseFirestore, engMapper, musicMapper, movieMapper, networkHandler)


}