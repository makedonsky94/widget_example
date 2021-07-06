package com.tradingview.widgets.presentation.widget.view

import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.tradingview.widgets.R
import com.tradingview.widgets.WidgetsApp

class WatchlistItemsViewsFactory : RemoteViewsService.RemoteViewsFactory {

    private var itemsCache: List<String> = listOf()

    override fun onCreate() = Unit

    override fun onDataSetChanged() {
        Log.d("TEST", "onDataSetChanged")
    }

    override fun onDestroy() = Unit

    override fun getCount(): Int = 50//itemsCache.count()

    override fun getViewAt(position: Int): RemoteViews {
        Log.d("TEST", "getViewAt")
        val packageName = WidgetsApp.instance.applicationContext.packageName
        return RemoteViews(packageName, R.layout.item_watchlist_widget)
    }

    override fun getLoadingView(): RemoteViews {
        Log.d("TEST", "getLoadingView")
        val packageName = WidgetsApp.instance.applicationContext.packageName
        return RemoteViews(packageName, R.layout.item_watchlist_skeleton)
    }

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = position.toLong()

    override fun hasStableIds(): Boolean = true
}