package com.tradingview.widgets.app.service.watchlist

import java.lang.IllegalArgumentException

class DescriptionServiceImpl : DescriptionService {
    override fun getSymbolDescription(symbolName: String): String {
        return symbolToDescriptionMap[symbolName]
            ?: throw IllegalArgumentException("Symbol $symbolName is not found")
    }

    private val symbolToDescriptionMap = mapOf(
        "AAPL" to "Apple Inc",
        "INTC" to "Intel Corporation",
        "AMZN" to "Amazon.com, Inc.",
        "NVDA" to "NVIDIA Corporation"
    )
}