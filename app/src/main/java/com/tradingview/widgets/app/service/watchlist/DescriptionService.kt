package com.tradingview.widgets.app.service.watchlist

interface DescriptionService {
    fun getSymbolDescription(symbolName: String): String
}