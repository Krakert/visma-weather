package com.visma.presentation.nav

sealed class Screen(val route: String) {
    object Overview : Screen("overview_coins")
    object Forecast : Screen("forecast")
}