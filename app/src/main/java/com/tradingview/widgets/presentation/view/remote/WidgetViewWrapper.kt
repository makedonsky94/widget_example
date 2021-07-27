package com.tradingview.widgets.presentation.view.remote

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.tradingview.widgets.presentation.view.widget.WatchlistWidgetViewsService
import com.tradingview.widgets.presentation.viewmodel.WatchlistViewModel
import com.tradingview.widgets.presentation.viewmodel.WidgetViewModel

object WidgetViewWrapper {
    fun createWithData(widgetId: Int, context: Context): WidgetView {
        val widgetView = WidgetView(context)
        val widgetViewModel = WidgetViewModel(widgetId = widgetId)
        widgetViewModel.widgetConfiguration?.let { configuration ->
            val watchlistViewModel = WatchlistViewModel(watchlistId = configuration.watchlistId)
            widgetView.setTitle(watchlistViewModel.name)
            widgetView.disableProgress()

            val adapterIntent = Intent(context, WatchlistWidgetViewsService::class.java)
            adapterIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId)
            adapterIntent.data = Uri.parse(adapterIntent.toUri(Intent.URI_INTENT_SCHEME))
            widgetView.createList(adapterIntent)
        }
        return widgetView
    }
}