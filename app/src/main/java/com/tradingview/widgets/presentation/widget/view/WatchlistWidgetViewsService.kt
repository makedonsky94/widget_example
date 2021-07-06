package com.tradingview.widgets.presentation.widget.view

import android.content.Intent
import android.widget.RemoteViewsService

class WatchlistWidgetViewsService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return WatchlistItemsViewsFactory()
    }
}