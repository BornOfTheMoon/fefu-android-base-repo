package com.example.first_homework.screens.detail_activity.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleService
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.*
import org.osmdroid.util.GeoPoint
import com.example.first_homework.App
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.database.Activity
import com.example.first_homework.database.ActivityFinishTimeUpdate
import com.example.first_homework.databinding.FragmentActivityActiveBinding
import com.example.first_homework.extensions.toFormattedDistance
import com.example.first_homework.extensions.toTimerFormat
import com.example.first_homework.screens.detail_activity.ActivityActivity
import com.example.first_homework.screens.detail_activity.ActivityService
import com.example.first_homework.screens.activity.MainActivityScreen
import java.time.Duration
import java.time.LocalDateTime

class ActivityActive:
    BaseFragment<FragmentActivityActiveBinding>(R.layout.fragment_activity_active)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activityId = requireArguments()["activityId"] as Int
        var reassembled = requireArguments()["reassembled"] as Boolean
        ActivityService.startForegroundTracking(requireContext(), activityId)

        val activityData: Activity = App.INSTANCE.database.activityDao().getById(activityId)

        binding.tvActivityType.text = activityData.type.title

        App.INSTANCE.database.activityDao().getLiveById(activityId)
            .observe(viewLifecycleOwner) {
                if (it.coordinates.isNotEmpty() && !reassembled) {
                    val lastCoordinate = it.coordinates.last()
                    (activity as ActivityActivity).polyline.addPoint(
                        GeoPoint(lastCoordinate.first, lastCoordinate.second)
                    )
                } else if (it.coordinates.isNotEmpty() && reassembled) {
                    it.coordinates.forEach {
                            coordinate ->
                        (activity as ActivityActivity).polyline.addPoint(
                            GeoPoint(coordinate.first, coordinate.second)
                        )
                    }
                    reassembled = false
                }
            }

        val uiJob = GlobalScope.launch {
            withContext(Dispatchers.IO) {
                while (true) {
                    activity?.runOnUiThread {
                        binding.tvTimer.text =
                            Duration.between(activityData.startTime, LocalDateTime.now()).toTimerFormat()

                        binding.tvDistance.text = ActivityService.distance.toFormattedDistance()

                    }
                    delay(1000L)
                }
            }
        }

        binding.bFinish.setOnClickListener {
            ActivityService.stopForegroundTracking(activity!!, activityId)

            App.INSTANCE.database.activityDao().updateFinishTime(
                ActivityFinishTimeUpdate(ActivityService.activityId, LocalDateTime.now()))

            uiJob.cancel()

            (it.parent as ViewGroup).removeView(it)

            (activity as ActivityActivity).binding.bBack.setOnClickListener {
                val intent = Intent(requireContext(), MainActivityScreen::class.java)
                startActivity(intent)
                (activity as ActivityActivity).finish()
                onDestroy()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }
}