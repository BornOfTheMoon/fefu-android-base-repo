package com.example.first_homework.screens.detail_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_homework.databinding.ActivityActivityBinding

class ActivityActivity: AppCompatActivity() {
    lateinit var binding: ActivityActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivityBinding.inflate(layoutInflater)
        binding.bBack.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }

    override fun onBackPressed() {
        finish()
    }
}