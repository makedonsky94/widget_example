package com.tradingview.widgets.presentation.view.configuration

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.tradingview.widgets.R
import com.tradingview.widgets.presentation.view.remote.WidgetViewWrapper
import com.tradingview.widgets.presentation.viewmodel.WatchlistsViewModel
import com.tradingview.widgets.presentation.viewmodel.WidgetsViewModel

class ConfigurationActivity : AppCompatActivity() {
    lateinit var radioGroup: RadioGroup
    private val watchlistsViewModel = WatchlistsViewModel()
    private val widgetsViewModel = WidgetsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appWidgetId = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID

        setContentView(R.layout.activity_coniguration)
        radioGroup = findViewById(R.id.configuration_rg_select_watch)
        watchlistsViewModel.watchlists.forEach { watchlist ->
            radioGroup.addView(
                RadioButton(this).apply {
                    id = watchlist.id
                    text = watchlist.name
                }
            )
        }
        findViewById<Button>(R.id.configuration_btn_apply).setOnClickListener {
            val watchlistId = radioGroup.checkedRadioButtonId
            if (watchlistId != -1) {
                widgetsViewModel.createConfiguration(appWidgetId, watchlistId)
                setResult(Activity.RESULT_OK, Intent().apply {
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                })
                updateWidget(appWidgetId)
                finish()
            }
        }
    }

    private fun updateWidget(appWidgetId: Int) {
        val widgetView = WidgetViewWrapper.createWithData(appWidgetId, this)
        val appWidgetManager = AppWidgetManager.getInstance(this)
        appWidgetManager.updateAppWidget(appWidgetId, widgetView)
    }
}