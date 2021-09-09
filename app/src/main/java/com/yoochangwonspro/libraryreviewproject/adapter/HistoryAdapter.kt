package com.yoochangwonspro.libraryreviewproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoochangwonspro.libraryreviewproject.databinding.ItemHistoryBinding
import com.yoochangwonspro.libraryreviewproject.model.History


class HistoryAdapter : ListAdapter<History, HistoryAdapter.HistoryItemViewHolder>(diffUtil) {

    inner class HistoryItemViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(historyModel: History) {

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<History>() {
            override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem.uid == newItem.uid
            }
        }
    }
}