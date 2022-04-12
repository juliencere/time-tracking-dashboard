package com.android.timetrackingdashboard.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.timetrackingdashboard.R
import java.io.IOException

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getData(getJsonDataString())

        return inflater.inflate(R.layout.main_fragment, container, false)
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