package com.visma.presentation.weather.overview.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.visma.presentation.extension.capitalize

@Composable
fun WeatherSearchBar(text: String, onDone: () -> Unit, onValueChange: (String) -> Unit) {

    Row(modifier = Modifier.padding(top = 64.dp, start = 24.dp, end = 24.dp)) {
        BasicTextField(
            textStyle = MaterialTheme.typography.displayLarge,
            singleLine = true,
            value = TextFieldValue(
                text = text, selection = TextRange(text.length)
            ),
            onValueChange = { newValue ->
                onValueChange(newValue.text.trim().capitalize())
            },
            keyboardActions = KeyboardActions(onDone = {
                onDone()
            })
        )
    }
}