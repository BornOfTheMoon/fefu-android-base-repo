package com.example.first_homework.screens.activity.fragments.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentActivitiesBinding
import com.example.first_homework.screens.activity.adapters.ViewPagerAdapter


class Activities: BaseFragment<FragmentActivitiesBinding>(R.layout.fragment_activities) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tlActivitiesTabs, binding.viewPager) {
            tab, position -> tab.text = when(position) {
                0 -> "Мои"
                1 -> "Пользователей"
                else -> ""
            }
        }.attach()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bStartNewActivity.setOnClickListener {
            val direction = ActivitiesDirections.actionActivitiesFragmentToActivityActivity()
            findNavController().navigate(direction)
        }
    }
}