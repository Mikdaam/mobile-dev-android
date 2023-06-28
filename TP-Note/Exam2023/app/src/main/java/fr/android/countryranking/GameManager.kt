package fr.android.countryranking

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun GameManager() {
    val rankingData = RankingData.loadRandomRankingData(LocalContext.current, "rankings")
    var score by remember { mutableStateOf(1) }
    var countriesToDisplay by remember { mutableStateOf(listOf(rankingData.countries.random())) }
    val countryToPlace by remember { mutableStateOf(rankingData.countries.random()) }
    var isGameOver by remember { mutableStateOf(false) }

    GameSession(
        ranking = rankingData.ranking,
        unit = rankingData.unit,
        countryToPlace = countryToPlace,
        rankingCountries = countriesToDisplay,
        score = score,
        onCountryClicked = { country ->
            if (country.value > countryToPlace.value) {
                score *= 2
                countriesToDisplay += countryToPlace
            } else {
                isGameOver = true
            }
        },
        isGameOver = isGameOver,
        onStartNewGame = {
            score = 1
            countriesToDisplay = mutableStateListOf()
            countriesToDisplay += countryToPlace
            isGameOver = false
        }
    )
}