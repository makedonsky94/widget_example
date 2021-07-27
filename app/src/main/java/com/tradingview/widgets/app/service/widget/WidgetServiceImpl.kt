package com.tradingview.widgets.app.service.widget

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import com.tradingview.widgets.WidgetsApp
import com.tradingview.widgets.core.store.Store
import com.tradingview.widgets.model.widget.Widget
import com.tradingview.widgets.model.widget.WidgetConfiguration
import com.tradingview.widgets.presentation.view.widget.WatchlistWidgetProvider

class WidgetServiceImpl(private val configurationStore: Store<WidgetConfiguration>) : WidgetService {
    private val context get() = WidgetsApp.instance.applicationContext

    override fun requestWidgets(): List<Widget> {
        val appWidgetManager = AppWidgetManager.getInstance(context)
        return appWidgetManager
            .getAppWidgetIds(ComponentName(context, WatchlistWidgetProvider::class.java))
            .map(::Widget)
    }

    override fun removeConfiguration(widgetId: Int) {
        val configuration = getConfiguration(widgetId)
        configurationStore.remove(configuration.id)
    }

    override fun getConfiguration(widgetId: Int): WidgetConfiguration {
        return configurationStore.getAll().first { it.widgetId == widgetId }
    }

    override fun addConfiguration(configuration: WidgetConfiguration) {
        configurationStore.add(configuration)
    }
}