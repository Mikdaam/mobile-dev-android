package fr.android.countryflag.fact

import fr.android.countryflag.countries.Country

enum class Fact(val title: String, val unit: String, val extractor: (Country) -> Float) {
    POPULATION("population", "people", { it.population.toFloat() }),
    AREA("area", "km²", { it.area }),
    DENSITY("density", "people/km²", { it.population / it.area }),
    GDP("gross domestic product", "$", { it.gdp }),
    GDP_PER_CAPITA("gross domestic product per capita", "$/person", { it.gdp / it.population }),
    UNEMPLOYMENT("unemployment rate", "%", { it.unemployment }),
    IMPORTS("imports", "$", { it.imports }),
    EXPORTS("exports", "$", { it.exports }),
    COMMERCIAL_BALANCE("commercial balance", "$", { it.exports - it.imports })
}