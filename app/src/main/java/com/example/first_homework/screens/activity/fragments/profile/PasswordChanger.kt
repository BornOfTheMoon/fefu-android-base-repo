package com.example.first_homework.screens.activity.fragments.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentProfilePasswordChangerBinding

class PasswordChanger:
    BaseFragment<FragmentProfilePasswordChangerBinding>(R.layout.fragment_profile_password_changer)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.tbTopbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        super.onViewCreated(view, savedInstanceState)
    }
}