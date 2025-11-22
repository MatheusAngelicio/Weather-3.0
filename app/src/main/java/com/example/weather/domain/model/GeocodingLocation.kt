package com.example.weather.domain.model

data class GeocodingLocation(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String,
    val state: String? = null,
)
