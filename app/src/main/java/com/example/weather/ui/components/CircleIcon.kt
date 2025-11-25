package com.example.weather.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weather.ui.theme.BlueAccent
import com.example.weather.ui.theme.DarkBlue

@Composable
fun CircleIcon(
    iconRes: Int,
    backgroundColor: Color = DarkBlue,
    iconTint: Color = BlueAccent,
    circleSize: Dp = 160.dp,
    iconSize: Dp = 72.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(circleSize)
            .background(
                color = backgroundColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(iconSize)
        )
    }
}
