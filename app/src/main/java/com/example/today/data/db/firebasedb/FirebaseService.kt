package com.example.today.data.db.firebasedb

import android.util.Log
import com.example.today.data.db.model.Movie
import com.example.today.data.db.model.Movie.Companion.toMovie
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

object FirebaseService{

    suspend fun getMovieData(day: Int): Movie? {
        val db = FirebaseFirestore.getInstance()
        return try {
            db.collection("movie").document(day.toString()).get().await().toMovie()
        } catch (e: Exception) {
            Log.e("FirebaseProfileService", "No such document")
            null
        }
    }

}