package com.example.today.presentation.homeFrag

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.today.databinding.ViewWeatherInfoBinding
import com.example.today.domain.model.Weather

class WeatherInfoView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private val binding: ViewWeatherInfoBinding

    init {
        val inflater = LayoutInflater.from(context)
        this.binding = ViewWeatherInfoBinding.inflate(inflater, this, true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Glide.get(this.context).clearMemory();
    }
    fun setWeather(weather: Weather) {
        binding.weather = weather
        Glide.with(this.context)
            .load(weather.icon)
            .into(binding.statusIcon)
    }
}