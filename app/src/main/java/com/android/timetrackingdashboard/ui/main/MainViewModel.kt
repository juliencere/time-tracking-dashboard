package com.android.timetrackingdashboard.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.timetrackingdashboard.buisness.data.model.TimeData
import com.android.timetrackingdashboard.buisness.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val mainRepository = MainRepository()
    private var timeData = MutableLiveData<List<TimeData>>()
    private var loadingState = MutableLiveData<LoadingState>()

    fun getTimeData(dataString: String) {
        loadingState.postValue(LoadingState.LOADING)
        viewModelScope.launch {
            val result = mainRepository.getTimeDataAsync(dataString)
            //TODO
            loadingState.postValue(LoadingState.OK)
        }
    }
}