package com.example.today.data.db.model

import android.os.Parcelable
import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize

@Parcelize
data class Eng(
    val title: String, //Document ID is actually the user id
    val director: String,
    val actor: String,
    val script: String,
    val time : String) : Parcelable {

    companion object {
        fun DocumentSnapshot.toMovie(): Eng? {
            try {
                val title = getString("title")!!
                val director = getString("director")!!
                val actor = getString("actor")!!
                val script = getString("script")!!
                val time = getString("time")!!
                return Eng(title, director, actor, script,time)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
        private const val TAG = "Eng"
    }
}
