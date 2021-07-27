package com.tradingview.widgets.presentation.view.remote

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RemoteViews
import com.tradingview.widgets.R

class WidgetView(context: Context) : RemoteViews(context.packageName, R.layout.layout_watchlist_widget) {

    fun setTitle(title: String) {
        setTextViewText(R.id.widget_watchlist_name, title)
    }

    fun disableProgress() {
        setViewVisibility(R.id.widget_vs, View.VISIBLE)
        setViewVisibility(R.id.widget_watchlist_skeleton, View.GONE)
    }

    fun createList(intent: Intent) {
        setRemoteAdapter(R.id.widget_watchlist_lv, intent)
    }

    fun setViewSizeTextToTitle(options: Bundle) {
        fun int(paramName: String): Int {
            return options.getInt(paramName)
        }
        val titleString =
            "[${int(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH)}x${int(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT)}]" +
            " " +
            "[${int(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)}x${int(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)}]"

        setTextViewText(R.id.widget_watchlist_name, titleString)
    }
}