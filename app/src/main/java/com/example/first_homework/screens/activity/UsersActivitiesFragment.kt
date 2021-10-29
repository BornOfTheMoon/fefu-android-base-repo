package com.example.first_homework.screens.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.first_homework.databinding.FragmentUsersActivitiesBinding

class UsersActivitiesFragment: Fragment() {
    private var _binding: FragmentUsersActivitiesBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance(): UsersActivitiesFragment {
            return  UsersActivitiesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersActivitiesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}