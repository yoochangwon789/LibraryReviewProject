package com.yoochangwonspro.libraryreviewproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bumptech.glide.Glide
import com.yoochangwonspro.libraryreviewproject.databinding.ActivityDetailBinding
import com.yoochangwonspro.libraryreviewproject.model.Book
import com.yoochangwonspro.libraryreviewproject.model.Review

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "BookSearchDB"
        ).build()

        val model = intent.getParcelableExtra<Book>("bookModel")

        binding.titleTextView.text = model?.title.orEmpty()
        binding.descriptionTextView.text = model?.description.orEmpty()

        Glide.with(binding.coverImageView)
            .load(model?.coverSmallUrl.orEmpty())
            .into(binding.coverImageView)

        Thread {
            val review = db.reviewDao().getOnReview(model?.id?.toInt() ?: 0)
            runOnUiThread {
                binding.reviewEditText.setText(review.review.orEmpty())
            }
        }

        binding.saveButton.setOnClickListener {
            Thread {
                db.reviewDao().saveReview(
                    Review(
                        model?.id?.toInt() ?: 0,
                        binding.reviewEditText.text.toString()
                    )
                )
            }.start()
        }
    }
}