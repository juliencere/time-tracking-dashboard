package com.android.timetrackingdashboard.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.timetrackingdashboard.R
import com.android.timetrackingdashboard.buisness.data.model.TimeData
import com.android.timetrackingdashboard.databinding.TimeFrameItemBinding
import com.android.timetrackingdashboard.ui.main.state.TimeStateEnum

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var items: List<TimeData> = mutableListOf()
    private var timeState: TimeStateEnum = TimeStateEnum.DAILY

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TimeFrameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.timeData = items[position]
        holder.binding.timeState = timeState
        holder.setHeader(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: List<TimeData>) {
        this.items = newItems
        notifyItemRangeChanged(0, newItems.size)
    }

    fun updateState(timeState: TimeStateEnum) {
        this.timeState = timeState
        notifyItemRangeChanged(0, items.size)
    }

    inner class ViewHolder(val binding: TimeFrameItemBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
        fun setHeader(item: TimeData) {
            when (item.title) {
                "Work" -> {
                    binding.backgroundCard.background.setTint(ContextCompat.getColor(context, R.color.light_orange))
                    binding.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_work))
                }
                "Play" -> {
                    binding.backgroundCard.background.setTint(ContextCompat.getColor(context, R.color.soft_blue))
                    binding.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play))
                }
                "Study" -> {
                    binding.backgroundCard.background.setTint(ContextCompat.getColor(context, R.color.light_red))
                    binding.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_study))
                }
                "Exercise" -> {
                    binding.backgroundCard.background.setTint(ContextCompat.getColor(context, R.color.lime_green))
                    binding.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_exercise))
                }
                "Social" -> {
                    binding.backgroundCard.background.setTint(ContextCompat.getColor(context, R.color.violet))
                    binding.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_social))
                }
                "Self Care" -> {
                    binding.backgroundCard.background.setTint(ContextCompat.getColor(context, R.color.soft_orange))
                    binding.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_self_care))
                }
            }
        }
    }
}