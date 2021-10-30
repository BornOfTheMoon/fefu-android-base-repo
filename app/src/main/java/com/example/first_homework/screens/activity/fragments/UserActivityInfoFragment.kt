package com.example.first_homework.screens.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.first_homework.App
import com.example.first_homework.databinding.UserActivityCardInfoBinding
import com.example.first_homework.models.IActivity
import com.example.first_homework.models.UserActivity

class UserActivityInfoFragment(private val activityData: IActivity): Fragment() {
    private var _binding: UserActivityCardInfoBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(activityData: IActivity): UserActivityInfoFragment {
            return UserActivityInfoFragment(activityData)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserActivityCardInfoBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).setSupportActionBar(binding.tbAction)
        activityData as UserActivity

        binding.tvMetric.text = activityData.metric
        binding.tbAction.title = activityData.name
        binding.tvDate.text = activityData.finishDate

        binding.tvStartTimeValue.text = activityData.startTime
        binding.tvFinishTimeValue.text = activityData.finishTime
        binding.tvUserName.text = activityData.userName
        binding.tvComment.text = activityData.userComment

        binding.tbAction.setNavigationOnClickListener {
            App.INSTANCE.router.Back()
        }

        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}