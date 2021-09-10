package com.yoochangwonspro.libraryreviewproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yoochangwonspro.libraryreviewproject.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}