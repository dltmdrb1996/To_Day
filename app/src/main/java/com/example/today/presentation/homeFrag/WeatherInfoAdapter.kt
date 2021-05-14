package com.example.today.presentation.homeFrag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.today.databinding.AdapterListBinding
import com.example.today.domain.model.LocationWeather


class WeatherInfoAdapter : RecyclerView.Adapter<WeatherInfoAdapter.WeatherInfoViewHolder>() {
    private val items: ArrayList<LocationWeather> = arrayListOf()

    fun addHeaderAndSumbitList(list: List<LocationWeather>) {
        val diffCallback = DiffUtilCallback(items, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    class WeatherInfoViewHolder constructor(val binding: AdapterListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LocationWeather) {
            binding.apply {
                viewModel = WeatherInfoViewModel(item)
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): WeatherInfoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = AdapterListBinding.inflate(layoutInflater, parent, false)
                return WeatherInfoViewHolder(binding)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherInfoViewHolder {
        return WeatherInfoViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return items.count()
    }


    override fun onBindViewHolder(holder: WeatherInfoViewHolder, position: Int) {

        val locationWeather = items[position]
        holder.bind(locationWeather)

    }

}



private class DiffUtilCallback(
    private val oldItems: List<LocationWeather>,
    private val newItems: List<LocationWeather>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int =
        oldItems.size

    override fun getNewListSize(): Int =
        newItems.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.locationId == newItem.locationId && oldItem.weathers == newItem.weathers
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]

        return oldItem == newItem
    }

    enum class PayloadKey {
        VALUE
    }
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return listOf(PayloadKey.VALUE)
    }
}
