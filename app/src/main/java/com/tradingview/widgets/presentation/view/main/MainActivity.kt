package com.tradingview.widgets.presentation.view.main

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.tradingview.widgets.R
import com.tradingview.widgets.presentation.viewmodel.WidgetsViewModel
import com.tradingview.widgets.presentation.view.widget.WatchlistWidgetProvider
import com.tradingview.widgets.presentation.view.widget.WidgetActions

class MainActivity : AppCompatActivity() {
    private val viewModel = WidgetsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_show_widget_in_picker).setOnClickListener {
            val appWidgetManager = AppWidgetManager.getInstance(this)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                appWidgetManager.updateAppWidgetProviderInfo(
                    ComponentName(this, WatchlistWidgetProvider::class.java),
                    "android.appwidget.provider"
                )
            }
        }

        findViewById<Button>(R.id.btn_hide_widget).setOnClickListener {
            val appWidgetManager = AppWidgetManager.getInstance(this)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                appWidgetManager.updateAppWidgetProviderInfo(
                    ComponentName(this, WatchlistWidgetProvider::class.java),
                    "test.provider"
                )
            }
        }

        findViewById<Button>(R.id.btn_add_widget).setOnClickListener {
            val appWidgetManager = AppWidgetManager.getInstance(this)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val ableToPin = appWidgetManager
                    .requestPinAppWidget(
                        ComponentName(this, WatchlistWidgetProvider::class.java),
                        null,
                        //TODO: call configuration activity here because it will not be opened automatically
                        null
                    )
                Log.d("TEST", "ableToPin: $ableToPin")
            } else {
                Log.d("TEST", "below android O")
                //show picker
            }
        }

        findViewById<Button>(R.id.btn_update).setOnClickListener {
            sendBroadcast(createIntent(AppWidgetManager.ACTION_APPWIDGET_UPDATE))
        }

        findViewById<Button>(R.id.btn_notify_data_changed).setOnClickListener {
            sendBroadcast(createIntent(WidgetActions.ACTION_NOTIFY_DATA_CHANGED))
        }
    }

    private fun createIntent(action: String): Intent {
        val intent = Intent(this, WatchlistWidgetProvider::class.java)
        intent.action = action
        intent.putExtra(
            AppWidgetManager.EXTRA_APPWIDGET_IDS,
            viewModel.createdWidgets.map { it.id }.toTypedArray()
        )
        return intent
    }
}