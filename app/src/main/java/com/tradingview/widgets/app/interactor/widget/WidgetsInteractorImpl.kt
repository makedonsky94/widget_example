package com.tradingview.widgets.app.interactor.widget

import com.tradingview.widgets.app.service.widget.WidgetService
import com.tradingview.widgets.model.widget.Widget
import com.tradingview.widgets.model.widget.WidgetConfiguration
import kotlin.random.Random

class WidgetsInteractorImpl(private val widgetService: WidgetService) : WidgetsInteractor {

    override fun getCreatedWidgets(): List<Widget> {
        return widgetService.requestWidgets()
    }

    override fun removeConfiguration(widgetId: Int) {
        widgetService.removeConfiguration(widgetId)
    }

    override fun createConfiguration(appWidgetId: Int, watchlistId: Int) {
        val configuration = WidgetConfiguration(Random.nextInt(), appWidgetId, watchlistId)
        widgetService.addConfiguration(configuration)
    }

    override fun getConfiguration(widgetId: Int): WidgetConfiguration {
        return widgetService.getConfiguration(widgetId)
    }
}