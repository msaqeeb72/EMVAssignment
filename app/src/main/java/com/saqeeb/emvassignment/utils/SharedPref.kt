package com.saqeeb.emvassignment.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor(@ApplicationContext val context:Context) {

    fun putString( key: String?, value: String?) {
        val settings: SharedPreferences = context.getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString( key: String?, defValue: String? = null): String? {
        val settings = context.getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE)
        return settings.getString(key, defValue)
    }

    fun clear() {
        val settings: SharedPreferences = context.getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.clear()
        editor.apply()
    }
}