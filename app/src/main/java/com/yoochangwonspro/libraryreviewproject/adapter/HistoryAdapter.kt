package com.yoochangwonspro.libraryreviewproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoochangwonspro.libraryreviewproject.databinding.ItemHistoryBinding
import com.yoochangwonspro.libraryreviewproject.model.History


class HistoryAdapter(
    val historyDeleteClickedListener: (String) -> Unit,
    val historyItemClickedListener: (String) -> Unit
) : ListAdapter<History, HistoryAdapter.HistoryItemViewHolder>(diffUtil) {

    inner class HistoryItemViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(historyModel: History) {
            binding.itemHistoryKeywordTextView.text = historyModel.keyword
            binding.itemHistoryKeywordDeleteButton.setOnClickListener {
                historyDeleteClickedListener(historyModel.keyword.orEmpty())
            }
            binding.root.setOnClickListener {
                historyItemClickedListener(historyModel.keyword.orEmpty())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        return HistoryItemViewHolder(
            ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<History>() {
            override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem.keyword == newItem.keyword
            }
        }
    }
}