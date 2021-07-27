package com.tradingview.widgets.presentation.viewmodel

import com.tradingview.widgets.app.interactor.widget.WidgetsInteractor
import com.tradingview.widgets.app.interactor.widget.WidgetsInteractorImpl
import com.tradingview.widgets.app.service.widget.WidgetServiceImpl
import com.tradingview.widgets.app.store.ConfigurationStore
import com.tradingview.widgets.model.widget.WidgetConfiguration

class WidgetViewModel(private val widgetId: Int) {
    private val widgetsInteractor: WidgetsInteractor = WidgetsInteractorImpl(WidgetServiceImpl(ConfigurationStore()))

    val widgetConfiguration: WidgetConfiguration?
        get() {
            return try {
                widgetsInteractor.getConfiguration(widgetId)
            } catch(e: NoSuchElementException) {
                null
            }
        }
}