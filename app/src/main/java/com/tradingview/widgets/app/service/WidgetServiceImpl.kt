package com.tradingview.widgets.app.service

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import com.tradingview.widgets.WidgetsApp
import com.tradingview.widgets.model.widget.Widget
import com.tradingview.widgets.presentation.widget.view.WatchlistWidgetProvider

class WidgetServiceImpl : WidgetService {
    private val context get() = WidgetsApp.instance.applicationContext

    override fun requestWidgets(): List<Widget> {
        val appWidgetManager = AppWidgetManager.getInstance(context)
        return appWidgetManager
            .getAppWidgetIds(ComponentName(context, WatchlistWidgetProvider::class.java))
            .map { Widget(it) }
    }
}