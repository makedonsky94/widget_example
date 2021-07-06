package com.tradingview.widgets.presentation.widget.view

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.RemoteViews
import com.tradingview.widgets.R
import kotlin.random.Random

class WatchlistWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.d("TEST", "onUpdate")
        appWidgetIds.forEach { id ->
            Log.d("TEST", "widget id = $id")
            val remoteViews = RemoteViews(context.packageName, R.layout.layout_watchlist_widget)
            appWidgetManager.updateAppWidget(id, remoteViews)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("TEST", "onReceive")
        when (intent.action) {
            WidgetActions.ACTION_CREATE_LIST -> {
                Log.d("TEST", "CREATE_LIST")
                intent.getWidgetIds().forEach { widgetId ->
                    Log.d("TEST", "widget id = $widgetId")
                    val widgetManager = AppWidgetManager.getInstance(context)
                    val remoteViews = RemoteViews(context.packageName, R.layout.layout_watchlist_widget)
                    remoteViews.setViewVisibility(R.id.widget_vs, View.VISIBLE)
                    remoteViews.setViewVisibility(R.id.widget_watchlist_skeleton, View.GONE)

                    val adapterIntent = Intent(context, WatchlistWidgetViewsService::class.java)
                    adapterIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId)
                    remoteViews.setRemoteAdapter(R.id.widget_watchlist_lv, adapterIntent)

                    widgetManager.updateAppWidget(widgetId, remoteViews)
                }
            }
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
}

object WidgetActions {
    const val ACTION_CREATE_LIST = "ACTION_CREATE_LIST"
    const val ACTION_NOTIFY_DATA_CHANGED = "ACTION_NOTIFY_DATA_CHANGED"
}

private fun Intent.getWidgetIds(): Array<Int> {
    val widgetIds = extras?.get(
        AppWidgetManager.EXTRA_APPWIDGET_IDS
    ) as? Array<Int>
    return widgetIds ?: arrayOf(AppWidgetManager.INVALID_APPWIDGET_ID)
}