package com.example.weather.navigation

object NavRoutes {
    const val SEARCH_CITIES = "search_cities"
    const val CITY_WEATHER_DETAILS = "city_weather_details"

    fun cityWeatherDetailsRoute(lat: Float, lon: Float): String {
        return "$CITY_WEATHER_DETAILS/$lat/$lon"
    }
}