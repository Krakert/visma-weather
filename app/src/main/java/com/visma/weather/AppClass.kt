package com.visma.weather

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeApp()
    }

    private fun initializeApp() {
        Timber.plant(Timber.DebugTree())
    }
}