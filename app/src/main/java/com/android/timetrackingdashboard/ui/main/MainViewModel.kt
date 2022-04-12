package com.android.timetrackingdashboard.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.timetrackingdashboard.buisness.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val mainRepository = MainRepository()
    var loadingState = MutableLiveData<LoadingState>()

    fun getData(dataString: String) {
        loadingState.postValue(LoadingState.LOADING)
        viewModelScope.launch {
            val result = mainRepository.getDataAsync(dataString)
            //TODO
            loadingState.postValue(LoadingState.OK)
        }
    }
}