package com.example.first_homework.screens.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.MyActivityCardInfoBinding
import com.example.first_homework.models.MyActivity

class MyActivityInfo:
    BaseFragment<MyActivityCardInfoBinding>(R.layout.my_activity_card_info) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState).also {
            val data: MyActivity = requireArguments().get("Activity") as MyActivity

            binding.tbAction.title = data.name
            binding.tvMetric.text = data.metric
            binding.tvStartTimeValue.text = data.startTime
            binding.tvFinishTimeValue.text = data.finishTime
            binding.tvDate.text = data.finishDate

            binding.tbAction.setNavigationOnClickListener{
                findNavController().popBackStack()
            }

        }
    }
}