package com.example.today.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Eng(
    @PrimaryKey @ColumnInfo(name = "num") var num: Int,
    @ColumnInfo(name = "kor") var kor: String,
    @ColumnInfo(name = "eng") var eng: String,
) {

}
