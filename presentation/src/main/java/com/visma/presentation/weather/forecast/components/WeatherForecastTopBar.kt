package com.visma.presentation.weather.forecast.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.visma.presentation.theme.LocalDimensions
import com.visma.presentation.theme.dimensions
import com.visma.weather.presentation.R

@Composable
fun WeatherForecastTopBar(onClick: () -> Unit) {
    Box(modifier = Modifier.padding(MaterialTheme.dimensions.spacingLarge)) {
        Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.spacingLarge)) {
            IconButton(modifier = Modifier.size(LocalDimensions.current.spacingForecastRow),
                onClick = { onClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back",
                    modifier = Modifier.size(32.dp)
                )
            }
            Text(
                text = stringResource(R.string.txt_forecast_5d),
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}