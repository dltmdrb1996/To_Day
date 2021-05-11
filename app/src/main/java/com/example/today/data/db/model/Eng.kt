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
    val img: String, //Document ID is actually the user id
    val person: String,
    val eng: String,
    val kor : String) : Parcelable {

    companion object {
        fun DocumentSnapshot.toEng(): Eng? {
            try {
                val eng = getString("eng")!!
                val kor = getString("kor")!!
                val img = getString("img")!!
                val person = getString("person")!!
                return Eng(img, person, eng, kor)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
        private const val TAG = "Eng"
    }
}
