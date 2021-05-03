package com.example.today.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IconUrlGenerator @Inject constructor() {
    fun getPngIconUrl(iconType: String): String = "https://www.metaweather.com/" + "static/img/weather/png/${iconType}.png"
}