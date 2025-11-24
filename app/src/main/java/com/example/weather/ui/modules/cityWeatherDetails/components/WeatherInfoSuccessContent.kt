package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather.core.utils.WeatherUtils.getUrlIcon
import com.example.weather.domain.model.CurrentWeather

@Composable
fun WeatherInfoSuccessContent(
    weatherInfo: CurrentWeather,
    modifier: Modifier = Modifier
) {
    weatherInfo.apply {
        val urlIcon = getUrlIcon(weatherInfo.icon)
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            MainWeatherInfo(
                urlIcon = urlIcon,
                currentTemp = temperature.toInt(),
                tempMin = tempMin.toInt(),
                tempMax = tempMax.toInt(),
                weatherDescription = description
            )
        }
    }
}