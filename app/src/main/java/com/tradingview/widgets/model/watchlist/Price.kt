package com.tradingview.widgets.model.watchlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Price(
    val value: String,
    val change: String
) : Parcelable