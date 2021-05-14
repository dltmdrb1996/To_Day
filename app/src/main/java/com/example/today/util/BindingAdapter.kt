package com.example.today.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
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

