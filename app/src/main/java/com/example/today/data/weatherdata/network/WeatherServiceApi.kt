package com.example.today.data.weatherdata.network

import com.example.today.data.weatherdata.model.LocationDTO
import com.example.today.data.weatherdata.model.LocationWeatherDTO
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherServiceApi {

    @GET("location/search")
    fun getLocations(@Query("query") search: String): Observable<Response<List<LocationDTO>>>

    @GET("location/{id}")
    fun getWeather(@Path("id") id: Long): Observable<Response<LocationWeatherDTO>>
}