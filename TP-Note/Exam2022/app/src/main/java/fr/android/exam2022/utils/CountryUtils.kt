package fr.android.exam2022.utils

import android.content.Context
import fr.android.exam2022.Country
import org.json.JSONArray
import java.io.IOException

fun loadCountries(context: Context): List<Country> {
    val countries = mutableListOf<Country>()
    val json = loadJSONFromAsset(context, "countries.json")
    if (json != null) {
        for (i in 0 until json.length()) {
            val country = json.getJSONObject(i)
            countries.add(
                Country(
                    country.getString("code"),
                    country.getString("name"),
                    country.getDouble("latitude"),
                    country.getDouble("longitude")
                )
            )
        }
    }
    return countries
}

fun loadJSONFromAsset(context: Context, fileName: String): JSONArray? {
    try {
        val inputStream = context.assets.open(fileName)
        inputStream.bufferedReader().use {
            return JSONArray(it.readText())
        }
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
}