package com.tradingview.widgets.presentation.view.remote

import android.content.Context
import android.widget.RemoteViews
import com.tradingview.widgets.R

class SymbolView(context: Context) : RemoteViews(context.packageName, R.layout.item_watchlist_widget) {

    var title: String? = null
        set(value) {
            setTextViewText(R.id.widget_tv_title, value)
            field = value
        }

    var description: String? = null
        set(value) {
            setTextViewText(R.id.widget_tv_description, value)
            field = value
        }

    var updateTime: String? = null
        set(value) {
            setTextViewText(R.id.widget_tv_update_time, value)
            field = value
        }

    var price: String? = null
        set(value) {
            setTextViewText(R.id.widget_tv_price, value)
            field = value
        }

    var priceChange: String? = null
        set(value) {
            setTextViewText(R.id.widget_tv_price_change, value)
            field = value
        }
}