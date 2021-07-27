package com.tradingview.widgets.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.tradingview.widgets.app.interactor.watchlist.WatchlistInteractor
import com.tradingview.widgets.app.interactor.watchlist.WatchlistInteractorImpl
import com.tradingview.widgets.app.service.watchlist.DescriptionServiceImpl
import com.tradingview.widgets.app.service.watchlist.PricesServiceImpl
import com.tradingview.widgets.app.service.watchlist.WatchlistServiceImpl
import com.tradingview.widgets.model.watchlist.Watchlist

class WatchlistsViewModel : ViewModel() {
    private val watchlistInteractor: WatchlistInteractor =
        WatchlistInteractorImpl(
            PricesServiceImpl(),
            WatchlistServiceImpl(),
            DescriptionServiceImpl(),
        )

    val watchlists: List<Watchlist>
        get() = watchlistInteractor.getAll()
}