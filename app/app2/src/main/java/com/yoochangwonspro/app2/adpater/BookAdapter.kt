package com.yoochangwonspro.app2.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoochangwonspro.app2.databinding.BookItemBinding
import com.yoochangwonspro.app2.model.Book

class BookAdapter: RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private var books: List<Book> = listOf()

    private lateinit var itemClickListener: (Book) -> Unit

    inner class ViewHolder(private val binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.titleTextView.text = book.title
            binding.descriptionTextView.text = book.description

            Glide.with(binding.coverImageView)
                .load(book.coverSmallUrl)
                .into(binding.coverImageView)

            binding.root.setOnClickListener {
                itemClickListener(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BookItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

    fun setData(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

    fun itemClickListener(itemClickListener: (Book) -> Unit) {
        this.itemClickListener = itemClickListener
    }
}