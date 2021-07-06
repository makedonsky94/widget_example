package com.tradingview.widgets.app.service

import com.tradingview.widgets.core.service.Service
import com.tradingview.widgets.model.widget.Widget

interface WidgetService : Service {
    fun requestWidgets(): List<Widget>
}