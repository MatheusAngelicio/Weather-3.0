package com.example.weather.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeocodingLocationResponse(
    @SerialName("name")
    val name: String,
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double,
    @SerialName("country")
    val country: String,
    @SerialName("state")
    val state: String? = null,
)