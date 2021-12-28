package com.yoochangwonspro.app2.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoochangwonspro.app2.databinding.HistoryItemBinding
import com.yoochangwonspro.app2.model.SearchHistory

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private var searchHistoryList: List<SearchHistory> = listOf()

    inner class ViewHolder(private val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(searchHistory: SearchHistory) {
            binding.searchHistoryTextView.text = searchHistory.historyName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HistoryItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchHistoryList[position])
    }

    override fun getItemCount(): Int = searchHistoryList.size

    fun setData(searchHistoryList: List<SearchHistory>) {
        this.searchHistoryList = searchHistoryList
        notifyDataSetChanged()
    }
}