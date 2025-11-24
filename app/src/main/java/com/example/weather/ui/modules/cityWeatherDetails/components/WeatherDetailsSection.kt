package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun WeatherDetailsSection(
    feelsLikeValue: String,
    humidityValue: String,
    windValue: String,
    minMaxTempValue: String,
    isDay: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WeatherDetailCard(
                icon = R.drawable.ic_thermostat,
                title = "Feels Like",
                value = feelsLikeValue,
                isDay = isDay,
                modifier = Modifier.weight(1f)
            )
            WeatherDetailCard(
                icon = R.drawable.ic_humidity,
                title = "Humidity",
                value = humidityValue,
                isDay = isDay,
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WeatherDetailCard(
                icon = R.drawable.ic_wind,
                title = "Wind",
                value = windValue,
                isDay = isDay,
                modifier = Modifier.weight(1f)
            )
            WeatherDetailCard(
                icon = R.drawable.ic_temp_min_max,
                title = "Min/Max",
                value = minMaxTempValue,
                isDay = isDay,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview
@Composable
private fun WeatherDetailsSectionPreview() {
    WeatherTheme {
        WeatherDetailsSection(
            feelsLikeValue = "25",
            humidityValue = "50",
            windValue = "10",
            minMaxTempValue = "10°C / 30°C",
            isDay = true,
        )
    }

}