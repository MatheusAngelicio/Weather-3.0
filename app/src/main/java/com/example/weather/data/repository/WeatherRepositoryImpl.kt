package com.example.weather.data.repository

import com.example.weather.data.mapper.toDomain
import com.example.weather.data.network.KtorClient
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.domain.model.GeocodingLocation
import com.example.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val ktorClient: KtorClient
) : WeatherRepository {

    override suspend fun getCityCoordinates(city: String): Result<GeocodingLocation> {
        return runCatching {
            val response = ktorClient.getCityCoordinates(
                city = city,
            )
            response.toDomain()
        }
    }

    override suspend fun getWeatherDetails(
        lat: Float,
        lon: Float
    ): Result<CurrentWeather> {
        return runCatching {
            val response = ktorClient.getCityCoordinates(
                lat = lat,
                lon = lon,
            )
            response.toDomain()
        }
    }
}