package com.example.weather.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("coord")
    val coord: Coord,
    @SerialName("weather")
    val weather: List<Weather>,
    @SerialName("base")
    val base: String,
    @SerialName("main")
    val main: Main,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("wind")
    val wind: Wind,
    @SerialName("rain")
    val rain: Rain? = null,
    @SerialName("clouds")
    val clouds: Clouds,
    @SerialName("dt")
    val dt: Long,
    @SerialName("sys")
    val sys: Sys,
    @SerialName("timezone")
    val timezone: Int,
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("cod")
    val cod: Int,
)

@Serializable
data class Coord(
    @SerialName("lon")
    val lon: Double,
    @SerialName("lat")
    val lat: Double,
)

@Serializable
data class Weather(
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val main: String,
    @SerialName("description")
    val description: String,
    @SerialName("icon")
    val icon: String,
)

@Serializable
data class Main(
    @SerialName("temp")
    val temp: Double,
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("temp_min")
    val tempMin: Double,
    @SerialName("temp_max")
    val tempMax: Double,
    @SerialName("pressure")
    val pressure: Int,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("sea_level")
    val seaLevel: Int? = null,
    @SerialName("grnd_level")
    val groundLevel: Int? = null,
)

@Serializable
data class Wind(
    @SerialName("speed")
    val speed: Double,
    @SerialName("deg")
    val deg: Int,
)

@Serializable
data class Rain(
    @SerialName("1h")
    val oneHour: Double? = null,
)

@Serializable
data class Clouds(
    @SerialName("all")
    val all: Int,
)

@Serializable
data class Sys(
    @SerialName("type")
    val type: Int? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("country")
    val country: String,
    @SerialName("sunrise")
    val sunrise: Long,
    @SerialName("sunset")
    val sunset: Long,
)
