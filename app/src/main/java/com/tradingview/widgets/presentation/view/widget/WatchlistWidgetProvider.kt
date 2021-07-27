package com.tradingview.widgets.presentation.view.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.tradingview.widgets.R
import com.tradingview.widgets.presentation.view.remote.WidgetViewWrapper
import com.tradingview.widgets.presentation.viewmodel.WidgetsViewModel

class WatchlistWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.d("TEST", "onUpdate")
        appWidgetIds.forEach { id ->
            Log.d("TEST", "widget id = $id")
            val widgetView = WidgetViewWrapper.createWithData(id, context)
            appWidgetManager.updateAppWidget(id, widgetView)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle
    ) {
        Log.d("TEST", "onAppWidgetOptionsChanged")
        Log.d("TEST", "widget id = $appWidgetId")
        val widgetView = WidgetViewWrapper.createWithData(appWidgetId, context)
        widgetView.setViewSizeTextToTitle(newOptions)
        appWidgetManager.updateAppWidget(appWidgetId, widgetView)
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
    }

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("TEST", "onReceive")
        when (intent.action) {
            WidgetActions.ACTION_NOTIFY_DATA_CHANGED -> {
                Log.d("TEST", "ACTION_NOTIFY_DATA_CHANGED")
                intent.getWidgetIds().forEach { widgetId ->
                    Log.d("TEST", "widget id = $widgetId")
                    val widgetManager = AppWidgetManager.getInstance(context)
                    widgetManager.notifyAppWidgetViewDataChanged(widgetId, R.id.widget_watchlist_lv)
                }
            }
        }
        super.onReceive(context, intent)
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        super.onDeleted(context, appWidgetIds)
        appWidgetIds.forEach { widgetId ->
            val widgetsViewModel = WidgetsViewModel()
            widgetsViewModel.removeConfiguration(widgetId)
        }
    }
}

object WidgetActions {
    const val ACTION_NOTIFY_DATA_CHANGED = "ACTION_NOTIFY_DATA_CHANGED"
}

private fun Intent.getWidgetIds(): Array<Int> {
    val widgetIds = extras?.get(
        AppWidgetManager.EXTRA_APPWIDGET_IDS
    ) as? Array<Int>
    return widgetIds ?: arrayOf(AppWidgetManager.INVALID_APPWIDGET_ID)
}