package com.example.today.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherDTO (
    @SerializedName("id")
    val id: Long,
    @SerializedName("weather_state_name")
    val state: String,
    @SerializedName("weather_state_abbr")
    val icon: String,
    @SerializedName("the_temp")
    val temp: Double,
    @SerializedName("humidity")
    val humidity: Int,
)