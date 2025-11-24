package com.example.weather.core.utils


object WeatherUtils {
    fun getUrlIcon(iconCode: String, size: String = "4x"): String {
        return "https://openweathermap.org/img/wn/${iconCode}@$size.png"
    }
}