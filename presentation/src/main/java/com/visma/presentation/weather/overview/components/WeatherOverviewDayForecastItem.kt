package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.visma.presentation.theme.BlueDayForecastItem
import com.visma.presentation.theme.dimensions

@Composable
fun WeatherDayForecastItem(time: String, icon: String, temp: String) {
    Box(
        modifier = Modifier.padding(
            horizontal = MaterialTheme.dimensions.spacingMedium,
            vertical = MaterialTheme.dimensions.spacingExtraSmall
        )
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(percent = 50))
                .background(color = BlueDayForecastItem)
                .padding(
                    horizontal = MaterialTheme.dimensions.spacingMedium,
                    vertical = MaterialTheme.dimensions.spacingExtraLarge
                )
                .width(75.dp), contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(
                        horizontal = MaterialTheme.dimensions.spacingExtraSmall,
                        vertical = MaterialTheme.dimensions.spacingMedium
                    ), text = time, style = MaterialTheme.typography.labelSmall
                )
                AsyncImage(
                    model = icon,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(72.dp)
                )
                Text(
                    modifier = Modifier.padding(
                        horizontal = MaterialTheme.dimensions.spacingExtraSmall,
                        vertical = MaterialTheme.dimensions.spacingMedium
                    ), text = temp, style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewWeatherDayForecastItem() {
    WeatherDayForecastItem("9AM", "", "16")
}