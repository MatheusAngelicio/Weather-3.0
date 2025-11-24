package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun MainWeatherInfo(
    urlIcon: String,
    currentTemp: Int,
    weatherDescription: String,
    tempMin: Int,
    tempMax: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        AsyncImage(
            model = urlIcon,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .aspectRatio(1f),
            contentScale = ContentScale.Fit
        )

        Text(
            "${currentTemp}°",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 100.sp,
            lineHeight = 60.sp,
            color = Color.White

        )
        Text(
            weatherDescription,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            lineHeight = 22.sp,
            color = Color.White
        )
        Row {
            Text(
                "H: ${tempMax}°",
                fontSize = 18.sp,
                lineHeight = 12.sp,
                color = Color.White,

                )
            Text(
                "L: ${tempMin}°",
                fontSize = 18.sp,
                lineHeight = 12.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun MainWeatherInfoPreview() {
    WeatherTheme {
        MainWeatherInfo(
            urlIcon = "https://openweathermap.org/img/wn/10d@4x.png",
            currentTemp = 25,
            weatherDescription = "Mostly Cloudy",
            tempMin = 18,
            tempMax = 29,
        )
    }
}