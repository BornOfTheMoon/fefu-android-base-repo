package com.example.first_homework

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.first_homework.databinding.MainScreenBinding

class MainScreenActivity : androidx.appcompat.app.AppCompatActivity() {
    private lateinit var binding: MainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindLoginButton()
        bindRegistrationButton()
    }

    private fun bindLoginButton() {
        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
        }
    }

    private fun bindRegistrationButton() {
        binding.registrationButton.setOnClickListener {
            val intent = Intent(this, RegistrationScreenActivity::class.java)
            startActivity(intent)
        }
    }
}