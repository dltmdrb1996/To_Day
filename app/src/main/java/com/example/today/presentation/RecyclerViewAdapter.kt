package com.example.today.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.today.R
import com.example.today.databinding.AdapterListBinding

class RecyclerViewAdapter(var items: ArrayList<String> = arrayListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val binding : AdapterListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout., parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount(): Int = items.size

    ...
}