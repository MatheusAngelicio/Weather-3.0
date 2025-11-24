package com.example.weather.domain.usecase

import com.example.weather.domain.model.CurrentWeather
import com.example.weather.domain.model.GeocodingLocation
import com.example.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
) : WeatherUseCase {

    override suspend fun getCityCoordinates(city: String): Result<GeocodingLocation> {
        return repository.getCityCoordinates(city)
    }

    override suspend fun getWeatherDetails(
        lat: Float,
        lon: Float
    ): Result<CurrentWeather> {
        return repository.getWeatherDetails(lat, lon)
    }
}