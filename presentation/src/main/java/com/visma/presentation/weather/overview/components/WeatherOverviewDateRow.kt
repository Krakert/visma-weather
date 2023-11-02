package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.visma.presentation.extension.shimmerEffect

@Composable
fun WeatherOverviewDateRow(isLoading: Boolean, date: String) {
    Row(modifier = Modifier.padding(horizontal = 24.dp)) {
        if (isLoading) {
            Box(
                modifier = Modifier
                    .size(height = 26.dp, width = 150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect()
            )
        } else {
            Text(text = date, style = MaterialTheme.typography.bodyMedium)
        }
    }
}