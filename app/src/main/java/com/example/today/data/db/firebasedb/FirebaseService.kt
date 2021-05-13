package com.example.today.data.db.firebasedb

import android.util.Log
import com.example.today.data.db.model.*
import com.example.today.data.db.model.EngDTO.Companion.toEng
import com.example.today.data.db.model.MovieDTO.Companion.toMovie
import com.example.today.data.db.model.MusicDTO.Companion.toMusic
import com.example.today.domain.mapper.MovieMapper
import com.example.today.domain.repository.FireBaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
object FirebaseService : FireBaseRepository{
    private val db = FirebaseFirestore.getInstance()

    override suspend fun getMovieData(day: Int): MovieDTO? {
        return try {
            db.collection("movie").document(day.toString()).get().await().toMovie()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

    override suspend fun getEngData(day: Int): EngDTO? {
        return try {
            db.collection("eng").document(day.toString()).get().await().toEng()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

    override suspend fun getMusicData(day: Int): MusicDTO? {
        return try {
            db.collection("music").document(day.toString()).get().await().toMusic()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }
}