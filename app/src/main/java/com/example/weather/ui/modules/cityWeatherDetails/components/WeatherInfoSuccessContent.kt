package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather.domain.model.CurrentWeather

@Composable
fun WeatherInfoSuccessContent(
    weatherInfo: CurrentWeather,
    modifier: Modifier = Modifier
) {
    weatherInfo.apply {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            MainWeatherInfo(
                icon = icon,
                currentTemp = temperature.toInt(),
                weatherDescription = description,
                tempMin = tempMin.toInt(),
                tempMax = tempMax.toInt(),
            )
        }
    }
}