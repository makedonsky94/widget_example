package com.tradingview.widgets.app.service.watchlist

import com.tradingview.widgets.model.watchlist.Price

interface PricesService {
    fun getPrice(symbolName: String): Price
}