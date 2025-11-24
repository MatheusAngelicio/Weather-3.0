package com.example.weather.domain.usecase

import com.example.weather.domain.model.CurrentWeather
import com.example.weather.domain.model.GeocodingLocation

interface WeatherUseCase {
    suspend fun getCityCoordinates(
        city: String,
    ): Result<GeocodingLocation>

    suspend fun getWeatherDetails(
        lat: Float,
        lon: Float,
    ): Result<CurrentWeather>
}
