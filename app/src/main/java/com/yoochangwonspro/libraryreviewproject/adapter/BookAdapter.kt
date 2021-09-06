package com.yoochangwonspro.libraryreviewproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoochangwonspro.libraryreviewproject.databinding.ItemBookBinding
import com.yoochangwonspro.libraryreviewproject.model.Book

class BookAdapter : ListAdapter<Book, BookAdapter.BookItemViewHolder>(diffUtil) {

    inner class BookItemViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookModel: Book) {
            binding.itemTitleTextView.text = bookModel.title
            binding.itemDescriptionTextView.text = bookModel.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        return BookItemViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    // DiffUtil
    // 리싸이클러뷰가 뷰의 position 이 변경이 되었을 때 새로운 값을 할당할지 말지 결정하는 기준이있다.
    // 같은 아이템이 또 올라오게 되면 굳이 같은 것을 또 할당할 필요가 없게 된다.
    // 그것을 결정이나 판단을 해주는 것이 DiffUtil 이다.

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                // oldItem 과 newItem 이 실제로 같은 것을 판단
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                // 안에 있는 컨텐츠가 실제로 같은 것을 판단
                return oldItem.id == newItem.id
            }
        }
    }
}