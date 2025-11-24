package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun WeatherDetailCard(
    icon: Int,
    title: String,
    value: String,
    isDay: Boolean,
    modifier: Modifier = Modifier,
) {
    val cardBackgroundColor = if (isDay) Color.White else Color.DarkGray
    val titleColor = if (isDay) Color.DarkGray else Color.White
    val valueColor = if (isDay) Color.Black else Color.LightGray
    val iconTint = if (isDay) Color.Black else Color.White

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = iconTint
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                    color = titleColor
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                color = valueColor
            )
        }
    }
}

@Preview
@Composable
private fun WeatherDetailCardPreview() {
    WeatherTheme {
        WeatherDetailCard(
            icon = R.drawable.ic_thermostat,
            title = "Feels Like",
            value = "25°C",
            isDay = true,
        )
    }
}