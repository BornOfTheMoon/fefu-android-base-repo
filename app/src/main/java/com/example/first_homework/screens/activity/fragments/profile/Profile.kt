package com.example.first_homework.screens.activity.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentProfileBinding

class Profile: BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.bChangePassword.setOnClickListener {
            val direction = ProfileDirections.actionProfileToPasswordChanger()
            findNavController().navigate(direction)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}