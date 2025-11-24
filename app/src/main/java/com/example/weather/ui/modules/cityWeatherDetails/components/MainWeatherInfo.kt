package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun MainWeatherInfo(
    urlIcon: String,
    currentTemp: Double,
    weatherDescription: String,
    tempMin: Double,
    tempMax: Double,
) {

}

@Preview
@Composable
private fun MainWeatherInfoPreview() {
    WeatherTheme {
        MainWeatherInfo(
            urlIcon = "https://openweathermap.org/img/wn/10d@4x.png",
            currentTemp = 25.toDouble(),
            weatherDescription = "Mostly Cloudy",
            tempMin = 18.toDouble(),
            tempMax = 29.toDouble(),
        )
    }
}