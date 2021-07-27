package com.tradingview.widgets.app.store

import android.content.Context
import com.tradingview.widgets.WidgetsApp
import com.tradingview.widgets.core.store.Store
import com.tradingview.widgets.model.widget.WidgetConfiguration
import java.lang.IllegalArgumentException

class ConfigurationStore : Store<WidgetConfiguration> {
    private val context = WidgetsApp.instance.applicationContext
    private val sharedPreferences = context
        .getSharedPreferences(ConfigurationStore::class.simpleName, Context.MODE_PRIVATE)

    override fun get(id: Int): WidgetConfiguration {
        if (sharedPreferences.getInt("id_$id", -1) != -1) {
            return WidgetConfiguration(
                id,
                sharedPreferences.getInt("widget_$id", -1),
                sharedPreferences.getInt("watchlist_$id", -1)
            )
        }
        throw IllegalArgumentException("Configuration with id $id is not found")
    }

    override fun getAll(): List<WidgetConfiguration> {
        return sharedPreferences.all
            .filter { it.key.contains(Regex("^id_[-]?\\d+")) }
            .values.fold(mutableListOf()) { list, id ->
                return@fold list.apply { add(this@ConfigurationStore.get(id as Int)) }
            }
    }

    override fun add(value: WidgetConfiguration) {
        val id = value.id
        sharedPreferences.edit()
            .putInt("id_$id", id)
            .putInt("widget_$id", value.widgetId)
            .putInt("watchlist_$id", value.watchlistId)
            .commit()
    }

    override fun remove(id: Int) {
        sharedPreferences.edit()
            .remove("id_$id")
            .remove("widget_$id")
            .remove("watchlist_$id")
            .commit()
    }
}