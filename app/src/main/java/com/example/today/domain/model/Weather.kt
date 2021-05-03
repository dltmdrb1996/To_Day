package com.example.today.domain.model

data class Weather (
    val id: Long,
    val state: String,
    val icon: String,
    val temp: Double,
    val humidity: Int,
)