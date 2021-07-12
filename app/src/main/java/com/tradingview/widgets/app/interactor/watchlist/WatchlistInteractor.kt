package com.tradingview.widgets.app.interactor.watchlist

import com.tradingview.widgets.model.watchlist.Watchlist

interface WatchlistInteractor {
    fun getWatchlist(watchlistId: Int): Watchlist
}