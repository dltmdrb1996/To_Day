package com.example.today.data.db.firebasedb

import android.util.Log
import com.example.today.data.db.model.Eng
import com.example.today.data.db.model.Eng.Companion.toEng
import com.example.today.data.db.model.Movie
import com.example.today.data.db.model.Movie.Companion.toMovie
import com.example.today.data.db.model.Music
import com.example.today.data.db.model.Music.Companion.toMusic
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

object FirebaseService{
    val db = FirebaseFirestore.getInstance()

    suspend fun getMovieData(day: Int): Movie? {
        return try {
            db.collection("movie").document(day.toString()).get().await().toMovie()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

    suspend fun getEngData(day: Int): Eng? {
        return try {
            db.collection("eng").document(day.toString()).get().await().toEng()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

    suspend fun getMusicData(day: Int): Music? {
        return try {
            db.collection("music").document(day.toString()).get().await().toMusic()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }
}