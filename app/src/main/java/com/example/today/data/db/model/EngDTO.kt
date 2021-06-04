package com.example.today.data.db.model

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize

@Parcelize
data class EngDTO(
    val img: String,
    val person: String,
    val eng: String,
    val kor : String) : Parcelable {

    companion object {
        fun DocumentSnapshot.toEng(): EngDTO? {
            try {
                val eng = getString("eng")!!
                val kor = getString("kor")!!
                val img = getString("img")!!
                val person = getString("person")!!
                return EngDTO(img, person, eng, kor)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
        private const val TAG = "Eng"
    }
}