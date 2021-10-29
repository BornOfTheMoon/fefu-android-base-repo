package com.example.first_homework.screens.main

import android.os.Bundle
import android.content.Intent
import com.example.first_homework.screens.registration.RegistrationScreenActivity
import com.example.first_homework.databinding.MainScreenBinding
import com.example.first_homework.screens.login.LoginScreenActivity

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