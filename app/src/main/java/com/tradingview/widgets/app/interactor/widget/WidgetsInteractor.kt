package com.tradingview.widgets.app.interactor.widget

import com.tradingview.widgets.model.widget.Widget

interface WidgetsInteractor {
    fun getCreatedWidgets(): List<Widget>
}