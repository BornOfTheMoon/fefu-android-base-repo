package com.example.first_homework.screens.activity.fragments.activities

import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_homework.App
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.database.Activity
import com.example.first_homework.databinding.FragmentMyActivitiesBinding
import com.example.first_homework.extensions.toDateSeparator
import com.example.first_homework.models.DateSeparator
import com.example.first_homework.models.IActivity
import com.example.first_homework.models.IListItem
import com.example.first_homework.models.MyActivity
import com.example.first_homework.screens.activity.adapters.ActivitiesViewAdapter

class MyActivities:
    BaseFragment<FragmentMyActivitiesBinding>(R.layout.fragment_my_activities) {

    private val _adapter = ActivitiesViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.lvActivities) {
            adapter = _adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        App.INSTANCE.database.activityDao().getAll().observe(viewLifecycleOwner) {
            activitiesList ->
            val packedList = packActivities(activitiesList)

            _adapter.submitList(packedList)

            if (packedList.isEmpty()) onMainScreen() else offMainScreen()

        }

        _adapter.setMyItemClickListener(::myActivityClickListener)

        switchButtonBehaviour()
    }

    override fun onResume() {
        super.onResume()
        switchButtonBehaviour()
    }

    private fun switchButtonBehaviour() {
        val lastActivity = App.INSTANCE.database.activityDao().getLast()

        lastActivity?.let {
            lastActivity.finishTime?.let {
                binding.bStartNewActivity.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_start)
                )
                binding.bStartNewActivity.setOnClickListener(::newActivityStarterListener)
            } ?: run {
                binding.bStartNewActivity.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_activity_started_timer)
                )
                binding.bStartNewActivity.setOnClickListener {
                    continueStartedActivity(lastActivity.id)
                }
            }
        } ?: run {
            binding.bStartNewActivity.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_start)
            )
            binding.bStartNewActivity.setOnClickListener(::newActivityStarterListener)
        }
    }


    private fun newActivityStarterListener(view: View) {
        println("new")
        val direction = ActivitiesDirections.actionActivitiesFragmentToActivityActivity()
        findNavController().navigate(direction)
    }

    private fun continueStartedActivity(activityId: Int) {
        println("continue")
        val direction = ActivitiesDirections.actionActivitiesFragmentToActivityActivity(
            activityId = activityId
        )
        findNavController().navigate(direction)
    }

    private fun myActivityClickListener(position: Int, activityData: IActivity) {
        val direction =
            ActivitiesDirections.
            actionActivitiesFragmentToMyActivityInfo((activityData as MyActivity).id)

        findNavController().navigate(direction)
    }

    private fun packActivities(activitiesList: List<Activity>): List<IListItem> {
        val activitiesMap = mutableMapOf<String, MutableList<MyActivity>>()

        activitiesList.forEach {
            it.finishTime?.let { finishTime ->
                if (!activitiesMap.containsKey(finishTime.toDateSeparator())) {
                    activitiesMap[finishTime.toDateSeparator()] = mutableListOf()
                }

                activitiesMap[finishTime.toDateSeparator()]?.add(it.toMyActivity())
            }
        }

        val packedList = mutableListOf<IListItem>()

        activitiesMap.forEach { (dateSeparatorContent, myActivitiesList) ->
            packedList.add(DateSeparator(dateSeparatorContent))
            myActivitiesList.forEach {
                packedList.add(it)
            }
        }

        return packedList
    }

    private fun offMainScreen() {
        binding.tvHeader.visibility = View.INVISIBLE
        binding.tvSubHeader.visibility = View.INVISIBLE
    }

    private fun onMainScreen() {
        binding.tvHeader.visibility = View.VISIBLE
        binding.tvSubHeader.visibility = View.VISIBLE
    }
}