package com.example.weather.domain.model

data class CurrentWeather(
    val cityName: String,
    val country: String,
    val temperature: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val humidity: Int,
    val description: String,
    val icon: String,
    val windSpeed: Double,
    val windDeg: Int,
    val lat: Double,
    val lon: Double,
    val isDay: Boolean,
)
