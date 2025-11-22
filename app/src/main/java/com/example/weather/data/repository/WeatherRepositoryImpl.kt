package com.example.weather.data.repository

import com.example.weather.data.network.KtorClient
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

            GeocodingLocation(
                name = response.name,
                lat = response.lat,
                lon = response.lon,
                country = response.country,
                state = response.state
            )
        }
    }
}