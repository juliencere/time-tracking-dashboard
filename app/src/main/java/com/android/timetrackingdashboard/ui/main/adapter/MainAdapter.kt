package com.android.timetrackingdashboard.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.timetrackingdashboard.buisness.data.model.TimeData
import com.android.timetrackingdashboard.databinding.TimeFrameItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var items: List<TimeData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TimeFrameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.timeData = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: List<TimeData>) {
        this.items = newItems
        notifyItemRangeChanged(0, newItems.size)
    }

    inner class ViewHolder(val binding: TimeFrameItemBinding) : RecyclerView.ViewHolder(binding.root)
}