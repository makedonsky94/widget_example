package com.tradingview.widgets.model.widget

import com.tradingview.widgets.core.store.Storable

data class WidgetConfiguration(
    override val id: Int,
    val widgetId: Int,
    val watchlistId: Int
) : Storable