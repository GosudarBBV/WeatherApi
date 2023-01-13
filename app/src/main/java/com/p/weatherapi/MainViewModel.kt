package com.p.weatherapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.p.weatherapi.adapters.WeatherModel

class MainViewModel: ViewModel() {

    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}