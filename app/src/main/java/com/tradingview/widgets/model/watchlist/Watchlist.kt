package com.tradingview.widgets.model.watchlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Watchlist(
    val id: Int,
    val name: String,
    val symbols: List<Symbol>
) : Parcelable