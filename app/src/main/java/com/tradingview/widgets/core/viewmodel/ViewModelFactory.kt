package com.tradingview.widgets.core.viewmodel

import kotlin.reflect.KClass

object ViewModelFactory {
    inline fun <reified T : ViewModel> provide(clazz: KClass<T>): T {
        return clazz.java.newInstance()
    }
}