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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseService @Inject constructor(
    private val db: FirebaseFirestore,
    private val engMapper: EngMapper,
    private val musicMapper: MusicMapper,
    private val movieMapper: MovieMapper
) : FireBaseRepository {

    override suspend fun getMovieData(day: Int): Movie? {
        return try {
            db.collection("movie").document(day.toString()).get().await().toMovie()?.let {
                movieMapper.transform(it)
            }
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

    override suspend fun getEngData(day: Int): Eng? {
        return try {
            db.collection("eng").document(day.toString()).get().await().toEng()?.let {
                engMapper.transform(it)
            }
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

    override suspend fun getMusicData(day: Int): Music? {
        return try {
            db.collection("music").document(day.toString()).get().await().toMusic()?.let {
                musicMapper.transform(it)
            }
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }
}