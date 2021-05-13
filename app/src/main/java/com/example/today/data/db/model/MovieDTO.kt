package com.example.today.data.db.model

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDTO(
    val title: String,
    val director: String,
    val img : String,
    val actor: String,
    val script: String,
    val story : String,
    val time : String) : Parcelable {

    companion object {
        fun DocumentSnapshot.toMovie(): MovieDTO? {
            try {
                val title = getString("title")!!
                val director = getString("director")!!
                val img = getString("img")!!
                val actor = getString("actor")!!
                val script = getString("script")!!
                val time = getString("time")!!
                val story = getString("story")!!
                return MovieDTO(title, director, img, actor, script,story, time)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
        private const val TAG = "User"
    }
}