package com.tradingview.widgets.model.watchlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Symbol(
    val name: String,
    val description: String,
    val price: Price
) : Parcelable