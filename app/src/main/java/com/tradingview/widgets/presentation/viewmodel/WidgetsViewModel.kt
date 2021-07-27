package com.tradingview.widgets.presentation.viewmodel

import com.tradingview.widgets.app.interactor.widget.WidgetsInteractor
import com.tradingview.widgets.app.interactor.widget.WidgetsInteractorImpl
import com.tradingview.widgets.app.service.widget.WidgetServiceImpl
import com.tradingview.widgets.app.store.ConfigurationStore
import com.tradingview.widgets.core.viewmodel.ViewModel
import com.tradingview.widgets.model.widget.Widget

class WidgetsViewModel : ViewModel {
    private val widgetsInteractor: WidgetsInteractor = WidgetsInteractorImpl(WidgetServiceImpl(ConfigurationStore()))

    val createdWidgets: List<Widget>
        get() = widgetsInteractor.getCreatedWidgets()

    fun createConfiguration(appWidgetId: Int, watchlistId: Int) {
        widgetsInteractor.createConfiguration(appWidgetId, watchlistId)
    }

    fun removeConfiguration(widgetId: Int) {
        widgetsInteractor.removeConfiguration(widgetId)
    }
}