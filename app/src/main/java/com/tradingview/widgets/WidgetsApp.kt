package com.tradingview.widgets

import android.app.Application

class WidgetsApp : Application() {
    companion object {
        lateinit var instance: WidgetsApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}