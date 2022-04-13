package com.android.timetrackingdashboard.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.timetrackingdashboard.databinding.MainFragmentBinding
import com.android.timetrackingdashboard.ui.main.adapter.MainAdapter
import java.io.IOException

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var timeDataAdapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getTimeData(getJsonDataString())

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        timeDataAdapter = MainAdapter(requireContext())
        binding.timeDataRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.timeDataRecycleView.adapter = timeDataAdapter

        viewModel.timeData.observe(viewLifecycleOwner) { results ->
            results?.let { timeDataItems ->
                timeDataAdapter.updateItems(timeDataItems)
            }
        }

        return binding.root
    }

    /**
     * Generates a json string from a local .json file to simulate data from an API endpoint.
     * This method requires context to access the assets file
     */
    private fun getJsonDataString(): String {
        var jsonString = ""
        try {
            jsonString = requireContext().assets.open("data.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
        }
        return jsonString
    }
}