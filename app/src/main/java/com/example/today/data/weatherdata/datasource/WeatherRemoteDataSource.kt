package com.example.today.data.weatherdata.datasource
import com.example.today.data.weatherdata.model.LocationDTO
import com.example.today.data.weatherdata.model.LocationWeatherDTO
import com.example.today.data.weatherdata.network.WeatherServiceApi
import com.example.today.di.IOScheduler
import com.example.today.util.error.HttpRequestFailException
import com.example.today.util.error.NullResponseBodyException
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject


class WeatherRemoteDataSource @Inject constructor(
private val weatherServiceApi: WeatherServiceApi,
@IOScheduler private val scheduler: Scheduler
) : WeatherDataSource {

    override fun getLocations(search: String): Observable<List<LocationDTO>> {
        return weatherServiceApi.getLocations(search).subscribeOn(scheduler).flatMap { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    Observable.just(it)
                } ?: Observable.error(NullResponseBodyException("get location response body is null"))
            } else {
                Observable.error(HttpRequestFailException("failure to get locations :${response.code()}"))
            }
        }
    }

    override fun getLocationWeather(id: Long): Observable<LocationWeatherDTO> {
        return weatherServiceApi.getWeather(id).subscribeOn(scheduler).flatMap { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    Observable.just(it)
                } ?: Observable.error(NullResponseBodyException("get location weather response body is null"))
            } else {
                Observable.error(HttpRequestFailException("failure to get location weather :${response.code()}"))
            }
        }
    }

}