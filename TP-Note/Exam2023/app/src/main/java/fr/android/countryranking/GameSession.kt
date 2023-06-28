package fr.android.countryranking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun GameSession(
    ranking: String,
    unit: String,
    countryToPlace: CountryValue,
    rankingCountries: List<CountryValue>,
    score: Int,
    onCountryClicked: (CountryValue) -> Unit,
    isGameOver: Boolean,
    onStartNewGame: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$ranking (${unit})")
        Text(text = "Score: $score")
        
        
        Card(
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
        ) {
            if (!isGameOver) {
                Text(text = "Rank this country:",)
                CountryDisplayer(code = countryToPlace.code, name = countryToPlace.name)
            } else {
                Button(onClick = {
                    onStartNewGame.invoke()
                }) {
                    Text(text = "Start a new game")
                }
            }
        }

        if (!isGameOver) {
            RankingDisplayer(
                data = rankingCountries,
                onClick = { index -> onCountryClicked.invoke(rankingCountries[index]) }
            )
        } else {
            RankingDisplayer(data = rankingCountries)
        }
    }
}