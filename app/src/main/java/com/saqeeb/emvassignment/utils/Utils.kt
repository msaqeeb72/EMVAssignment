package com.saqeeb.emvassignment.utils

import android.content.Context
import android.widget.Toast

object Utils {
    fun showToast(context:Context,message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        val assetManager = context.assets
        return assetManager.open(fileName).bufferedReader().use { it.readText() }
    }
}