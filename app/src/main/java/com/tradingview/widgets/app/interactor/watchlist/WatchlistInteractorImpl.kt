package com.tradingview.widgets.app.interactor.watchlist

import com.tradingview.widgets.app.service.watchlist.PricesService
import com.tradingview.widgets.app.service.watchlist.WatchlistService
import com.tradingview.widgets.model.watchlist.Symbol
import com.tradingview.widgets.model.watchlist.Watchlist

class WatchlistInteractorImpl(
    private val pricesService: PricesService,
    private val watchlistService: WatchlistService
) : WatchlistInteractor {
    override fun getWatchlist(watchlistId: Int): Watchlist {
        val symbols = watchlistService.getSymbols(watchlistId)
            .map { symbolName -> Symbol(symbolName, pricesService.getPrice(symbolName)) }
        return Watchlist("Watchlist $watchlistId", symbols)
    }
}