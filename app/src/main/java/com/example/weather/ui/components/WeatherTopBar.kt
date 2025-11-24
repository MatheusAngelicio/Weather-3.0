package com.example.weather.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.WeatherTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopBar(
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.background,
    onBack: ((() -> Unit))? = null
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                subtitle?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.LightGray,
                        fontSize = 14.sp,
                    )
                }
            }

        },
        navigationIcon = {
            onBack?.let {
                IconButton(
                    onClick = it
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color
        )
    )
}

@Preview
@Composable
private fun WeatherTopBarPreview() {
    WeatherTheme {
        WeatherTopBar(title = "Weather", onBack = {})
    }
}