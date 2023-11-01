package com.visma.presentation.weather.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.visma.presentation.OnDisplay
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.theme.BlackForecastScreen
import com.visma.presentation.theme.GreyForecastScreen

@Composable
fun WeatherForecastScreen(
    navController: NavHostController,
    viewModel: WeatherForecastViewModel,
    city: String
) {

    val contentForecast by viewModel.weatherOverviewForecast.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeatherForecast(city)
    }

    Column(
        modifier = Modifier
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        IconButton(modifier = Modifier.size(54.dp),
            onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = GreyForecastScreen,
                contentDescription = "Back",
                modifier = Modifier
                    .size(32.dp)
            )
        }
        Text(
            text = "Forecast next 14 days",
            style = MaterialTheme.typography.displayLarge.copy(
                color = BlackForecastScreen
            )
        )

        when (val state = contentForecast) {
            is OnDisplay -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    state.display.result.forEach {
                        item {
                            Text(
                                text = it.date, style = MaterialTheme.typography.displayLarge.copy(
                                    BlackForecastScreen
                                )
                            )
                            LazyColumn(modifier = Modifier.height(100.dp)) {
                                it.forecasts.forEach {
                                    item {
                                        Row {
                                            Text(
                                                text = it.time,
                                                style = MaterialTheme.typography.labelSmall.copy(
                                                    BlackForecastScreen
                                                )
                                            )
                                            Spacer(modifier = Modifier.weight(1f))
                                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
                                                verticalAlignment = Alignment.CenterVertically) {

                                                AsyncImage(
                                                    model = it.icon,
                                                    contentDescription = "",
                                                    contentScale = ContentScale.Fit,
                                                    modifier = Modifier.size(48.dp)
                                                )
                                                Text(
                                                    text = it.temperature,
                                                    style = MaterialTheme.typography.labelSmall.copy(
                                                        BlackForecastScreen
                                                    )
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }

            is OnError -> {
            }

            OnLoading -> {
            }
        }
    }

}