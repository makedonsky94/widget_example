package com.tradingview.widgets.presentation.main.viewmodel

import com.tradingview.widgets.app.interactor.widget.WidgetsInteractor
import com.tradingview.widgets.app.interactor.widget.WidgetsInteractorImpl
import com.tradingview.widgets.app.service.WidgetServiceImpl
import com.tradingview.widgets.core.viewmodel.ViewModel
import com.tradingview.widgets.model.widget.Widget

class WidgetsViewModel : ViewModel {
    private val widgetsInteractor: WidgetsInteractor = WidgetsInteractorImpl(WidgetServiceImpl())

    val createdWidgets: List<Widget>
        get() = widgetsInteractor.getCreatedWidgets()
}