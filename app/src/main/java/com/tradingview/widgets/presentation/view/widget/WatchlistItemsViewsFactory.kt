package com.tradingview.widgets.presentation.view.widget

import android.content.Context
import android.text.format.DateFormat
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.tradingview.widgets.WidgetsApp
import com.tradingview.widgets.model.watchlist.Symbol
import com.tradingview.widgets.presentation.view.remote.SymbolLoadingView
import com.tradingview.widgets.presentation.view.remote.SymbolView
import com.tradingview.widgets.presentation.viewmodel.WatchlistViewModel
import com.tradingview.widgets.presentation.viewmodel.WidgetViewModel
import java.util.*

class WatchlistItemsViewsFactory(private val widgetId: Int) : RemoteViewsService.RemoteViewsFactory {

    private val itemsCache: List<Symbol>
        get() {
            val widgetViewModel = WidgetViewModel(widgetId = widgetId)
            return widgetViewModel.widgetConfiguration?.let { configuration ->
                val viewModel = WatchlistViewModel(watchlistId = configuration.watchlistId)
                return@let viewModel.symbols
            } ?: listOf()
        }

    private val context: Context get() = WidgetsApp.instance.applicationContext

    override fun onCreate() = Unit

    override fun onDataSetChanged() {
        Log.d("TEST", "onDataSetChanged for widgetId $widgetId")
    }

    override fun onDestroy() = Unit

    override fun getCount(): Int = itemsCache.count()

    override fun getViewAt(position: Int): RemoteViews {
        Log.d("TEST", "getViewAt $position")
        return SymbolView(context).apply {
            val symbol = itemsCache[position]
            title = symbol.name
            description = symbol.description
            updateTime = DateFormat.getTimeFormat(context).format(Date())
            price = symbol.price.value
            priceChange = symbol.price.change
        }
    }

    override fun getLoadingView(): RemoteViews {
        Log.d("TEST", "getLoadingView")
        return SymbolLoadingView(context)
    }

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = position.toLong()

    override fun hasStableIds(): Boolean = true
}