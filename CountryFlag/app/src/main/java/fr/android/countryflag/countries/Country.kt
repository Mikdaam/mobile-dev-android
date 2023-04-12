package fr.android.countryflag.countries

import androidx.compose.runtime.Composable

sealed class Country(
    val name: String,
    val population: Int,
    val area: Float,
    val gdp: Float,
    val unemployment: Float,
    val imports: Float,
    val exports: Float,
    val flag: @Composable () -> Unit
)

val ALL_COUNTRIES = Country::class.sealedSubclasses.mapNotNull { it.objectInstance }
