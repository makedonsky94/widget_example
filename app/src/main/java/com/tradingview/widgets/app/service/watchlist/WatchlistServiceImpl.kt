package com.tradingview.widgets.app.service.watchlist

class WatchlistServiceImpl : WatchlistService {
    override fun getSymbols(watchlistId: Int): List<String> {
        return listOf(
            "APPL", "INTC", "AMZN"
        )
    }

    private val watchlists = mapOf(
        0 to listOf(
            "APPL", "INTC", "AMZN"
        ),
        1 to listOf(
            "AMZN", "INTC", "AAPL"
        )
    )
}