package com.example.today.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Eng(
    val img: String,
    val person: String,
    val eng: String,
    val kor: String
) : Parcelable
