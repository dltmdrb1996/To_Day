package com.example.today.presentation.saveFrag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.today.databinding.SaveViewHolderBinding
import com.example.today.domain.model.Save


class SaveAdapter(private val viewModel: SaveFragViewModel) :
    ListAdapter<Save, SaveAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: SaveViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: SaveFragViewModel, item: Save) {
            binding.item = item
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SaveViewHolderBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class TaskDiffCallback : DiffUtil.ItemCallback<Save>() {
    override fun areItemsTheSame(oldItem: Save, newItem: Save): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Save, newItem: Save): Boolean {
        return oldItem == newItem
    }
}

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Save>?) {
    items?.let {
        (listView.adapter as SaveAdapter).submitList(items)
    }
}
