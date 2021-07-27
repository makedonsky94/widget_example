package com.tradingview.widgets.presentation.view.widget

import android.appwidget.AppWidgetManager
import android.content.Intent
import android.widget.RemoteViewsService
import com.tradingview.widgets.presentation.view.widget.WatchlistItemsViewsFactory

class WatchlistWidgetViewsService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        val widgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
        return WatchlistItemsViewsFactory(widgetId)
    }
}