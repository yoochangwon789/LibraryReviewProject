package com.yoochangwonspro.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoochangwonspro.app2.databinding.ActivityMainBinding
import com.yoochangwonspro.app2.response.MyKey

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}