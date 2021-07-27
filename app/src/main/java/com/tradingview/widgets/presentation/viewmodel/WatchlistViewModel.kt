package com.tradingview.widgets.presentation.viewmodel

import com.tradingview.widgets.app.interactor.watchlist.WatchlistInteractor
import com.tradingview.widgets.app.interactor.watchlist.WatchlistInteractorImpl
import com.tradingview.widgets.app.service.watchlist.DescriptionServiceImpl
import com.tradingview.widgets.app.service.watchlist.PricesServiceImpl
import com.tradingview.widgets.app.service.watchlist.WatchlistServiceImpl
import com.tradingview.widgets.core.viewmodel.ViewModel
import com.tradingview.widgets.model.watchlist.Symbol

class WatchlistViewModel(private val watchlistId: Int) : ViewModel {
    private val watchlistInteractor: WatchlistInteractor =
        WatchlistInteractorImpl(
            PricesServiceImpl(),
            WatchlistServiceImpl(),
            DescriptionServiceImpl(),
        )

    val symbols: List<Symbol>
        get() = watchlistInteractor.getWatchlist(watchlistId).symbols

    val name: String
        get() = watchlistInteractor.getWatchlist(watchlistId).name
}