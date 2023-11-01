package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import com.visma.presentation.theme.BlueDayForecastRow
import com.visma.presentation.theme.LocalShapes
import com.visma.presentation.theme.dimensions
import com.visma.presentation.weather.overview.formatter.DegreeFormatter
import com.visma.presentation.weather.overview.model.WeatherForecastTodayItemDisplay

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
                .width(65.dp), contentAlignment = Alignment.Center
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
                    modifier = Modifier.size(48.dp)
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

@Preview
@Composable
fun PreviewWeatherDayForecastRow() {
    WeatherDayForecastRow(
        listOf(
            WeatherForecastTodayItemDisplay("9AM", "",  DegreeFormatter().map("16")),
            WeatherForecastTodayItemDisplay("10AM", "", DegreeFormatter().map("17")),
            WeatherForecastTodayItemDisplay("11AM", "", DegreeFormatter().map("18")),
            WeatherForecastTodayItemDisplay("12AM", "", DegreeFormatter().map("19")),
            WeatherForecastTodayItemDisplay("1PM", "", DegreeFormatter().map("22")),
            WeatherForecastTodayItemDisplay("2PM", "", DegreeFormatter().map("21")),
            WeatherForecastTodayItemDisplay("3PM", "", DegreeFormatter().map("18")),
            WeatherForecastTodayItemDisplay("4PM", "", DegreeFormatter().map("16")),
            WeatherForecastTodayItemDisplay("5PM", "", DegreeFormatter().map("15")),
            WeatherForecastTodayItemDisplay("6PM", "", DegreeFormatter().map("13"))
        )
    )
}

@Composable
fun WeatherDayForecastRow(forecast: List<WeatherForecastTodayItemDisplay>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Box(modifier = Modifier.padding(start = 54.dp, end = 32.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(LocalShapes.current.forecastRowShape)
                        .background(BlueDayForecastRow)
                        .padding(
                            horizontal = MaterialTheme.dimensions.spacingExtraLarge,
                            vertical = MaterialTheme.dimensions.spacingExtraLarge
                        )
                ) {
                    Row(
                    ) {
                        forecast.forEach {
                            WeatherDayForecastItem(
                                time = it.time, icon = it.icon, temp = it.temperature
                            )
                        }
                    }
                }
            }
        }
    }

}