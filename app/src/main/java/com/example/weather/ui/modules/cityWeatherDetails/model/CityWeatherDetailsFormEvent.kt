package com.example.weather.ui.modules.cityWeatherDetails.model


sealed interface CityWeatherDetailsFormEvent {
    data object OnRetryFetchWeatherDetails : CityWeatherDetailsFormEvent
}