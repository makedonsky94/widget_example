package com.tradingview.widgets.core.store

interface Store<T : Storable> {
    fun get(id: Int): T
    fun getAll(): List<T>
    fun add(value: T)
    fun remove(id: Int)
}