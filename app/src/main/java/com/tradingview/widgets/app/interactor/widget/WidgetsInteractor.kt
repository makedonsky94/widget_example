package com.tradingview.widgets.app.interactor.widget

import com.tradingview.widgets.model.widget.Widget
import com.tradingview.widgets.model.widget.WidgetConfiguration

interface WidgetsInteractor {
    fun getCreatedWidgets(): List<Widget>
    fun createConfiguration(appWidgetId: Int, watchlistId: Int)
    fun getConfiguration(widgetId: Int): WidgetConfiguration
    fun removeConfiguration(widgetId: Int)
}