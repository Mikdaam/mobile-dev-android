package fr.android.countryranking

import android.content.Context
import java.io.InputStream

data class RankingData(
    val ranking: String,
    val unit: String,
    val countries: List<CountryValue>
) {
    companion object {
        private fun loadFromInputStream(input: InputStream): RankingData {
            val lines = input.bufferedReader().readLines()
            val ranking = lines[0]
            val unit = lines[1]
            val countries = lines.subList(2, lines.size).map {
                val (code, name, value) = it.split("\t")
                CountryValue(code, name, value.toFloat())
            }
            return RankingData(ranking, unit, countries)
        }

        fun loadRandomRankingData(context: Context, assetDir: String): RankingData {
            val assetManager = context.assets
            val assetList = assetManager.list(assetDir)
            val randomAsset = assetList?.random()
            val inputStream = assetManager.open("$assetDir/$randomAsset")
            return loadFromInputStream(inputStream)
        }
    }
}
