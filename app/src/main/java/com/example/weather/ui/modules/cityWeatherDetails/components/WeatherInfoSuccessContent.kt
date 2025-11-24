package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather.core.utils.WeatherUtils.getUrlIcon
import com.example.weather.domain.model.CurrentWeather

@Composable
fun WeatherInfoSuccessContent(
    weatherInfo: CurrentWeather,
) {
    weatherInfo.apply {
        val urlIcon = getUrlIcon(weatherInfo.icon)
        MainWeatherInfo(
            urlIcon = urlIcon,
            currentTemp = temperature,
            tempMin = tempMin,
            tempMax = tempMax,
            weatherDescription = description,
        )
    }

}