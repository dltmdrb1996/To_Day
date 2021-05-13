package com.example.today.data.db.model

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize


@Parcelize
data class Music(
    val title: String, //Document ID is actually the user id
    val singer: String,
    val cast: String,
    val script : String,
    val url : String,
    val album : String) : Parcelable {

    companion object {
        fun DocumentSnapshot.toMusic(): Music? {
            return try {
                val title = getString("title")!!
                val singer = getString("singer")!!
                val cast = getString("cast")!!
                val script = getString("script")!!
                val url = getString("url")!!
                val album = getString("album")!!
                Music(title, singer, cast, script,url,album)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                null
            }
        }
        private const val TAG = "Music"
    }
}
