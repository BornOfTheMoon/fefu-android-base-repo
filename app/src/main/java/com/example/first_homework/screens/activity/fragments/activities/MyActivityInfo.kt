package com.example.first_homework.screens.activity.fragments.activities

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.first_homework.App
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.MyActivityCardInfoBinding
import com.example.first_homework.models.MyActivity

class MyActivityInfo:
    BaseFragment<MyActivityCardInfoBinding>(R.layout.my_activity_card_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activityId: Int = requireArguments().getInt("activityId")
        val data: MyActivity = App.INSTANCE.database.activityDao().getById(activityId).toMyActivity()

        binding.tbAction.title = data.name
        binding.tvMetric.text = data.metric
        binding.tvStartTimeValue.text = data.startTime
        binding.tvFinishTimeValue.text = data.finishTime
        binding.tvDate.text = data.finishDate
        binding.tvTime.text = data.duration

        binding.tbAction.setNavigationOnClickListener{
            findNavController().popBackStack()
        }

        binding.tbAction.setOnMenuItemClickListener {
            when (it.order) {
                MenuItemType.Delete.ordinal -> {
                    App.INSTANCE.database.activityDao().deleteById(data.id)
                    findNavController().popBackStack()
                }
                else -> {}
            }
            true
        }

        super.onViewCreated(view, savedInstanceState)
    }
}

internal enum class MenuItemType {
    Delete,
    Share
}