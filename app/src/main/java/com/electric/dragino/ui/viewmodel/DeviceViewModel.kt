package com.electric.dragino.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.electric.dragino.repository.FirebaseRepository
import com.electric.dragino.data.DeviceModel
import kotlinx.coroutines.*

class DeviceViewModel(private val repository: FirebaseRepository) : ViewModel() {
    private val _deviceData = MutableLiveData<DeviceModel>()
    val deviceData: LiveData<DeviceModel>
        get() = _deviceData

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getDeviceData(deviceId: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                repository.getDeviceData(deviceId) { device ->
                    _deviceData.postValue(device)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}