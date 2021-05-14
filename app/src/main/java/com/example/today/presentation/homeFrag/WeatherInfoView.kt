package com.example.today.presentation.homeFrag

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.today.databinding.ViewWeatherInfoBinding
import com.example.today.domain.model.Weather

class WeatherInfoView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private val binding: ViewWeatherInfoBinding

    init {
        Glide.get(this.context).clearMemory();
        val inflater = LayoutInflater.from(context)
        this.binding = ViewWeatherInfoBinding.inflate(inflater, this, true)
    }

    fun setWeather(weather: Weather) {
        binding.weather = weather
        Glide.with(this.context)
            .load(weather.icon)
//            .skipMemoryCache(true)
            .into(binding.statusIcon)

    }
}