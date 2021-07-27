package com.tradingview.widgets.app.service.widget

import com.tradingview.widgets.core.service.Service
import com.tradingview.widgets.model.widget.Widget
import com.tradingview.widgets.model.widget.WidgetConfiguration

interface WidgetService : Service {
    fun requestWidgets(): List<Widget>
    fun addConfiguration(configuration: WidgetConfiguration)
    fun getConfiguration(widgetId: Int): WidgetConfiguration
    fun removeConfiguration(widgetId: Int)
}