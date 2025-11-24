package com.example.weather.data.mapper

import com.example.weather.data.network.model.GeocodingLocationResponse
import com.example.weather.domain.model.GeocodingLocation

fun GeocodingLocationResponse.toDomain(): GeocodingLocation {
    return GeocodingLocation(
        name = name,
        lat = lat,
        lon = lon,
        country = country,
        state = state
    )
}