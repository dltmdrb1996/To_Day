package com.example.today.domain.model

data class Save(
    val title : String,
    val id : Int
){
    fun stringId() : String{
        return id.toString()
    }
}
