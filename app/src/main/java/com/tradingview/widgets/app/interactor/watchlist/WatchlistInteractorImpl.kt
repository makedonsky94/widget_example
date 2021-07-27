package com.tradingview.widgets.app.interactor.watchlist

import com.tradingview.widgets.app.service.watchlist.DescriptionService
import com.tradingview.widgets.app.service.watchlist.PricesService
import com.tradingview.widgets.app.service.watchlist.WatchlistService
import com.tradingview.widgets.model.watchlist.Symbol
import com.tradingview.widgets.model.watchlist.Watchlist

class WatchlistInteractorImpl(
    private val pricesService: PricesService,
    private val watchlistService: WatchlistService,
    private val descriptionService: DescriptionService
) : WatchlistInteractor {
    override fun getWatchlist(watchlistId: Int): Watchlist {
        val symbols = watchlistService.getSymbols(watchlistId)
            .map { symbolName ->
                Symbol(
                    symbolName,
                    descriptionService.getSymbolDescription(symbolName),
                    pricesService.getPrice(symbolName)
                )
            }
        val watchlistName = watchlistService.getWatchlistName(watchlistId)
        return Watchlist(watchlistId, watchlistName, symbols)
    }

    override fun getAll(): List<Watchlist> {
        return watchlistService.getAll().fold(mutableListOf()) { watchlists, watchlistId ->
            watchlists.add(getWatchlist(watchlistId))
            return@fold watchlists
        }
    }
}