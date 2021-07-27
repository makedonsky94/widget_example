package com.tradingview.widgets.app.service.watchlist

import java.lang.IllegalArgumentException

class WatchlistServiceImpl : WatchlistService {
    override fun getSymbols(watchlistId: Int): List<String> {
        return watchlists[watchlistId]?.second
            ?: throw IllegalArgumentException("Watchlist with id $watchlistId is not found")
    }

    override fun getWatchlistName(watchlistId: Int): String {
        return watchlists[watchlistId]?.first
            ?: throw IllegalArgumentException("Watchlist with id $watchlistId is not found")
    }

    override fun getAll(): List<Int> {
        return watchlists.keys.toList()
    }

    private val watchlists = mapOf(
        0 to Pair("First Watchlist", listOf("AAPL", "INTC", "AMZN")),
        1 to Pair("Second Watchlist", listOf("NVDA", "INTC", "AAPL"))
    )
}