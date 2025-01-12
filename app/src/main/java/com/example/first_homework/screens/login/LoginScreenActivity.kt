package com.example.first_homework.screens.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_homework.databinding.LoginScreenBinding

class LoginScreenActivity: AppCompatActivity() {
    private lateinit var binding: LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tbTopbar.setNavigationOnClickListener {
            finish()
        }
    }
}