package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.ui.theme.WeatherTheme

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

            Spacer(modifier = Modifier.height(20.dp))

            WeatherDetailsSection(
                feelsLikeValue = "${feelsLike.toInt()}°C",
                humidityValue = "$humidity %",
                windValue = "$windSpeed km/h",
                minMaxTempValue = "${tempMin.toInt()}°C/${tempMax.toInt()}°C",
                isDay = isDay
            )
        }
    }
}

@Preview
@Composable
private fun WeatherInfoSuccessContentPreview() {
    WeatherTheme {
        WeatherInfoSuccessContent(
            weatherInfo = CurrentWeather(
                cityName = "São Paulo",
                country = "BR",
                description = "description",
                icon = "icon",
                temperature = 20.0,
                tempMin = 10.0,
                tempMax = 30.0,
                isDay = false,
                humidity = 50,
                windSpeed = 10.0,
                windDeg = 10,
                feelsLike = 10.0,
                lat = 10.0,
                lon = 10.0
            )
        )
    }
}