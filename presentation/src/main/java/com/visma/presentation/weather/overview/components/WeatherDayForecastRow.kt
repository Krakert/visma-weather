package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.visma.presentation.extension.shimmerEffect
import com.visma.presentation.theme.BlueDayForecastRow
import com.visma.presentation.theme.LocalShapes
import com.visma.presentation.theme.dimensions
import com.visma.presentation.weather.formatter.DegreeFormatter
import com.visma.presentation.weather.model.WeatherForecastItemDisplay


@Preview
@Composable
fun PreviewWeatherDayForecastRow() {
    WeatherDayForecastRow(
        isLoading = true,
        listOf(
            WeatherForecastItemDisplay("9AM", "", DegreeFormatter().map("16")),
            WeatherForecastItemDisplay("10AM", "", DegreeFormatter().map("17")),
            WeatherForecastItemDisplay("11AM", "", DegreeFormatter().map("18")),
            WeatherForecastItemDisplay("12AM", "", DegreeFormatter().map("19")),
            WeatherForecastItemDisplay("1PM", "", DegreeFormatter().map("22")),
            WeatherForecastItemDisplay("2PM", "", DegreeFormatter().map("21")),
            WeatherForecastItemDisplay("3PM", "", DegreeFormatter().map("18")),
            WeatherForecastItemDisplay("4PM", "", DegreeFormatter().map("16")),
            WeatherForecastItemDisplay("5PM", "", DegreeFormatter().map("15")),
            WeatherForecastItemDisplay("6PM", "", DegreeFormatter().map("13"))
        )
    )
}

@Composable
fun WeatherDayForecastRow(isLoading: Boolean, forecast: List<WeatherForecastItemDisplay>) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .padding(start = 54.dp)
                .fillMaxWidth()
                .height(232.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp))
                .shimmerEffect()
        )
    } else {
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
}