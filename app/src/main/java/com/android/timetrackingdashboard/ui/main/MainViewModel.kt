package com.android.timetrackingdashboard.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.timetrackingdashboard.buisness.data.model.TimeData
import com.android.timetrackingdashboard.buisness.repository.MainRepository
import com.android.timetrackingdashboard.ui.main.state.LoadingState
import com.android.timetrackingdashboard.ui.main.state.TimeStateEnum
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val mainRepository = MainRepository()
    val timeData = MutableLiveData<List<TimeData>>()
    val loadingState = MutableLiveData<LoadingState>()
    val timeState = MutableLiveData<TimeStateEnum>()

    init {
        timeState.value = TimeStateEnum.WEEKLY
    }

    fun getTimeData(dataString: String) {
        loadingState.postValue(LoadingState.LOADING)
        viewModelScope.launch {
            val result: List<TimeData>? = mainRepository.getTimeDataAsync(dataString)
            result?.let {
                timeData.postValue(it)
            }
            loadingState.postValue(LoadingState.OK)
        }
    }
}