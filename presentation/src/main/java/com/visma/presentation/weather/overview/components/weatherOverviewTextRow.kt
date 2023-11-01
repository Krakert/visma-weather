package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.visma.presentation.extension.shimmerEffect
import com.visma.weather.presentation.R

@Composable
fun WeatherOverviewTextRow(isLoading: Boolean, onClick: () -> Unit) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .padding(start = 54.dp, end = 32.dp)
                .height(height = 26.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .shimmerEffect()
        )
    } else {
        Row(
            modifier = Modifier
                .padding(start = 54.dp, end = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                modifier = Modifier.padding(end = 16.dp),
                text = stringResource(R.string.txt_forecast),
                style = MaterialTheme.typography.labelSmall.copy(Color.White)
            )
            Text(
                modifier = Modifier.clickable {
                    onClick()
                },
                text = stringResource(R.string.txt_upcoming_days),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}