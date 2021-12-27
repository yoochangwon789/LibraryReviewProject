package com.yoochangwonspro.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yoochangwonspro.app2.databinding.ActivityDetailBinding
import com.yoochangwonspro.app2.model.Book

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() = with(binding) {
        val bookModel = intent.getParcelableExtra<Book>("bookModel")

        detailTitleTextView.text = bookModel?.title ?: ""
        detailDescriptionTextView.text = bookModel?.description ?: ""

        Glide.with(detailImageView)
            .load(bookModel?.coverSmallUrl)
            .into(detailImageView)
    }
}