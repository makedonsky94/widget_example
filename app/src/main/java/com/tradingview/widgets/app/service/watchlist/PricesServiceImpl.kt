package com.tradingview.widgets.app.service.watchlist

import com.tradingview.widgets.model.watchlist.Price
import com.tradingview.widgets.model.watchlist.Symbol
import java.lang.IllegalArgumentException

class PricesServiceImpl : PricesService {
    override fun getPrice(symbolName: String): Price {
        return symbolToPriceMap[symbolName]
            ?: throw IllegalArgumentException("Symbol '$symbolName' is not found.")
    }

    private val symbolToPriceMap = mapOf(
        "AAPL" to Price("145.18", "+1.94 +1.36%"),
        "INTC" to Price("56.09", "+0.71 +1.28%"),
        "AMZN" to Price("3725.41", "-6.00 -0.16%"),
        "NVDA" to Price("190.44", "-2.44 -1.26%")
    )
}