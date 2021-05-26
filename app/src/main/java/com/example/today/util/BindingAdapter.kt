package com.example.today.util

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.today.domain.model.LocationWeather
import com.example.today.presentation.homeFrag.WeatherInfoAdapter

@BindingAdapter("adapterViewPager")
fun bindAdapterViewPager(view: ViewPager2, list: List<LocationWeather>?) {
    list?.let { itemList ->
        view.adapter?.apply {
            (this as WeatherInfoAdapter).addHeaderAndSumbitList(itemList)
        }
    }

}

