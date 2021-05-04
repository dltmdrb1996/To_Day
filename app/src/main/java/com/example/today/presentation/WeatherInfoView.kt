package com.example.today.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.today.databinding.AdapterHeaderBinding
import com.example.today.domain.model.Weather

class WeatherInfoView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private val binding: AdapterHeaderBinding

    init {
        val inflater = LayoutInflater.from(context)
        this.binding = AdapterHeaderBinding.inflate(inflater, this, true)
    }

    fun setWeather(weather: Weather) {
        binding.weather = weather
    }

}