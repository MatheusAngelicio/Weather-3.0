package com.example.weather.data.network

import com.example.weather.data.network.model.CurrentWeatherResponse
import com.example.weather.data.network.model.GeocodingLocationResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class KtorClient @Inject constructor(private val client: HttpClient) {
    suspend fun getCityCoordinates(
        city: String,
    ): GeocodingLocationResponse {
        val result = client
            .get("geo/1.0/direct?q=${city}&limit=1")
            .body<List<GeocodingLocationResponse>>()

        if (result.isEmpty()) {
            throw IllegalStateException("City $city not found")
        }

        return result.first()
    }

    suspend fun getCityCoordinates(
        lat: Float,
        lon: Float,
    ): CurrentWeatherResponse {
        return client
            .get("data/2.5/weather?lat=${lat}&lon=${lon}")
            .body<CurrentWeatherResponse>()
    }

}