package com.example.first_homework.screens.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.UserActivityCardInfoBinding
import com.example.first_homework.models.UserActivity

class UserActivityInfo:
    BaseFragment<UserActivityCardInfoBinding>(R.layout.user_activity_card_info) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState).also {
            val data: UserActivity = requireArguments().get("Activity") as UserActivity

            binding.tbAction.title = data.name
            binding.tvMetric.text = data.metric
            binding.tvStartTimeValue.text = data.startTime
            binding.tvFinishTimeValue.text = data.finishTime
            binding.tvDate.text = data.finishDate
            binding.tvUserName.text = data.userName
            binding.tvComment.text = data.userComment

            binding.tbAction.setNavigationOnClickListener{
                findNavController().popBackStack()
            }
        }
    }
}