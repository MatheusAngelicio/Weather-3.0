package com.example.weather.data.mapper

import com.example.weather.data.network.model.CurrentWeatherResponse
import com.example.weather.domain.model.CurrentWeather

fun CurrentWeatherResponse.toDomain(): CurrentWeather {
    return CurrentWeather(
        cityName = name,
        country = sys.country,
        temperature = main.temp,
        feelsLike = main.feelsLike,
        tempMin = main.tempMin,
        tempMax = main.tempMax,
        humidity = main.humidity,
        description = weather.firstOrNull()?.description ?: "",
        icon = weather.firstOrNull()?.icon ?: "",
        windSpeed = wind.speed,
        windDeg = wind.deg,
        lat = coord.lat,
        lon = coord.lon
    )
}
