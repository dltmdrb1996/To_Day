package com.example.today.data.db.firebasedb

import android.util.Log
import com.example.today.data.db.model.EngDTO.Companion.toEng
import com.example.today.data.db.model.MovieDTO.Companion.toMovie
import com.example.today.data.db.model.MusicDTO.Companion.toMusic
import com.example.today.data.mapper.EngMapper
import com.example.today.data.mapper.MovieMapper
import com.example.today.data.mapper.MusicMapper
import com.example.today.domain.model.Eng
import com.example.today.domain.model.Movie
import com.example.today.domain.model.Music
import com.example.today.domain.repository.FireBaseRepository
import com.example.today.util.Either
import com.example.today.util.NetworkHandler
import com.example.today.util.error.Failure
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore,
    private val engMapper: EngMapper,
    private val musicMapper: MusicMapper,
    private val movieMapper: MovieMapper,
    private val networkHandler: NetworkHandler
) : FireBaseRepository {

    override suspend fun getMovieData(day: Int): Either<Failure, Movie?> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> db.collection("movie")
                .document(day.toString()).get().await().toMovie()?.let {
                    Either.Right(movieMapper.transform(it))
                } ?: Either.Left(Failure.ServerError)
            false -> Either.Left(Failure.NetworkConnection)
        }
    }

    override suspend fun getEngData(day: Int): Either<Failure, Eng?> {

        return when (networkHandler.isNetworkAvailable()) {
            true -> db.collection("eng")
                .document(day.toString()).get().await().toEng()?.let {
                    Either.Right(engMapper.transform(it))
                } ?: Either.Left(Failure.ServerError)
            false -> Either.Left(Failure.NetworkConnection)
        }
    }

    override suspend fun getMusicData(day: Int): Either<Failure, Music?> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> db.collection("music")
                .document(day.toString()).get().await().toMusic()?.let {
                    Either.Right(musicMapper.transform(it))
                } ?: Either.Left(Failure.ServerError)
            false -> Either.Left(Failure.NetworkConnection)
        }
    }
}