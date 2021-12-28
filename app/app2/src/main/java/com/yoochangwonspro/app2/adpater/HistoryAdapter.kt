package com.yoochangwonspro.app2.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoochangwonspro.app2.databinding.HistoryItemBinding
import com.yoochangwonspro.app2.model.History

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private var historyList: List<History> = listOf()

    inner class ViewHolder(private val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(history: History) {
            binding.searchHistoryTextView.text = history.historyName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HistoryItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount(): Int = historyList.size

    fun setData(historyList: List<History>) {
        this.historyList = historyList
        notifyDataSetChanged()
    }
}