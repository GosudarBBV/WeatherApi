package com.p.weatherapi.adapters

data class WeatherModel(
    val city:String,
    val time:String,
    val condition:String,
    val currentTemp:String,
    val maxTemp:String,
    val minTemp:String,
    val imageUri:String,
    val hours:String
)