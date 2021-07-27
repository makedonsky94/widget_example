package com.tradingview.widgets.app.service.watchlist

interface WatchlistService {
    fun getSymbols(watchlistId: Int): List<String>
    fun getWatchlistName(watchlistId: Int): String
    fun getAll(): List<Int>
}