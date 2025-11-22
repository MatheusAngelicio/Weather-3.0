package com.example.weather.domain.usecase

import com.example.weather.domain.model.GeocodingLocation

interface WeatherUseCase {
    suspend fun getCityCoordinates(
        city: String,
    ): Result<GeocodingLocation>
}
