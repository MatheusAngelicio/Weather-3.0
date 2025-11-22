package com.example.weather.domain.repository

import com.example.weather.domain.model.GeocodingLocation

interface WeatherRepository {
    suspend fun getCityCoordinates(
        city: String,
    ): Result<GeocodingLocation>
}