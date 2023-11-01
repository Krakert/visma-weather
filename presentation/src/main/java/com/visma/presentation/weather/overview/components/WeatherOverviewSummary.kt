package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.visma.presentation.components.CenterElement
import com.visma.weather.presentation.R

@Composable
fun WeatherOverviewSummary(icon: String, temp: String, desc: String) {
    CenterElement {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.txt_today),
                style = MaterialTheme.typography.displayLarge
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(icon).build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp)
                )
                Text(
                    text = temp, style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = desc, style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}