package com.example.first_homework.screens.activity.fragments.activities

import android.os.Build
import android.os.Bundle
import android.transition.Visibility
import android.view.View
import androidx.annotation.RequiresApi
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
import com.example.first_homework.screens.activity.Activities
import com.example.first_homework.screens.activity.adapters.ActivitiesViewAdapter

class MyActivities:
    BaseFragment<FragmentMyActivitiesBinding>(R.layout.fragment_my_activities) {

    private val _adapter = ActivitiesViewAdapter()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.lvActivities) {
            adapter = _adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        App.INSTANCE.database.activityDao().getAll().observe(viewLifecycleOwner) { activitiesList ->
            val packedList = packActivities(activitiesList)

            _adapter.submitList(packedList)

            if (packedList.isEmpty()) onMainScreen() else offMainScreen()

        }

        _adapter.setMyItemClickListener(::myActivityClickListener)

        binding.bStartNewActivity.setOnClickListener(::newActivityStarterListener)
    }


    private fun newActivityStarterListener(view: View) {
        val direction = ActivitiesDirections.actionActivitiesFragmentToActivityActivity()
        findNavController().navigate(direction)
    }

    private fun myActivityClickListener(position: Int, activityData: IActivity) {
        val direction =
            ActivitiesDirections.actionActivitiesFragmentToMyActivityInfo(activityData as MyActivity)

        findNavController().navigate(direction)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun packActivities(activitiesList: List<Activity>): List<IListItem> {
        val activitiesMap = mutableMapOf<String, MutableList<MyActivity>>()

        activitiesList.forEach {
            if (!activitiesMap.containsKey(it.finishTime.toDateSeparator())) {
                activitiesMap[it.finishTime.toDateSeparator()] = mutableListOf()
            }

            activitiesMap[it.finishTime.toDateSeparator()]?.add(it.toMyActivity())
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