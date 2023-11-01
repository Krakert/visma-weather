package com.visma.presentation.weather.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.visma.presentation.OnDisplay
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.components.CenterElement
import com.visma.presentation.extension.capitalize
import com.visma.presentation.theme.Blue40
import com.visma.presentation.theme.Blue80

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WeatherOverviewScreen(navController: NavHostController, viewModel: WeatherOverviewViewModel) {

    val contentTodayState by viewModel.weatherOverviewTodayContentState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    var value by rememberSaveable { mutableStateOf("London") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Blue80, Blue40)
                )
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                keyboardController?.hide()
                focusManager.clearFocus(true)
            }
    ) {
        // Search bar for the city
        Column {
            Row(modifier = Modifier.padding(top = 64.dp, start = 24.dp, end = 24.dp)) {
                BasicTextField(
                    textStyle = MaterialTheme.typography.displayLarge,
                    singleLine = true,
                    value = TextFieldValue(
                        text = value,
                        selection = TextRange(value.length)
                    ),
                    onValueChange = { newValue ->
                        value = newValue.text.trim().capitalize()
                    },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            viewModel.fetchWeatherOverview(value)
                            focusManager.clearFocus(true)
                            keyboardController?.hide()
                        })
                )
            }


            when (val state = contentTodayState) {
                is OnDisplay -> {
                    CenterElement {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Today", style = MaterialTheme.typography.displayLarge)
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(state.display.icon)
                                        .build(),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(100.dp)
                                )
                                Text(
                                    text = state.display.temperature,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                            Text(text = state.display.description, style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }

                is OnError -> {
                    TODO()
                }

                OnLoading -> {
                    Text(text = "Loading")
                }
            }
        }

    }
}
