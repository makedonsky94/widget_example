package com.tradingview.widgets.app.interactor.widget

import com.tradingview.widgets.app.service.widget.WidgetService
import com.tradingview.widgets.model.widget.Widget

class WidgetsInteractorImpl(private val widgetService: WidgetService) : WidgetsInteractor {

    override fun getCreatedWidgets(): List<Widget> {
        return widgetService.requestWidgets()
    }
}