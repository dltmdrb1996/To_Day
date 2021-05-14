package com.example.today.presentation.homeFrag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.today.databinding.AdapterListBinding
import com.example.today.domain.model.LocationWeather


class WeatherInfoAdapter : RecyclerView.Adapter<WeatherInfoAdapter.WeatherInfoViewHolder>() {

    private var items: List<weatherInfoItem> = emptyList()

    fun addHeaderAndSumbitList(list: List<LocationWeather>) {
        val itemList: MutableList<weatherInfoItem> = mutableListOf()
        val diffCallback = DiffUtilCallback(this.items, itemList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        if (!list.isEmpty()) {
            for (i in list) {

                itemList.add(weatherInfoItem(i))
            }
        }
        this.items = itemList
        notifyDataSetChanged()
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


    data class weatherInfoItem(val locationWeather: LocationWeather)


    override fun onBindViewHolder(holder: WeatherInfoViewHolder, position: Int) {

        val weatherInfoItem = items[position]
        holder.bind(weatherInfoItem.locationWeather)

    }

}



private class DiffUtilCallback(
    private val oldItems: List<WeatherInfoAdapter.weatherInfoItem>,
    private val newItems: List<WeatherInfoAdapter.weatherInfoItem>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int =
        oldItems.size

    override fun getNewListSize(): Int =
        newItems.size

    /**
     * 고유 값을 비교하는게 좋다.
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]

        return oldItem.locationWeather.locationId == newItem.locationWeather.locationId
    }

    /**
     * 아이템을 서로 비교하는게 좋다.
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]

        return oldItem == newItem
    }


}
