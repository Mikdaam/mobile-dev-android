package fr.android.countryranking

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This component called RankingDisplayer displays a ranking (List<RankingValue>). It displays a scrolling list of countries in the form of CountryDisplayer. Two display variants are possible:
//
//a variant simply displaying countries
//another variant displaying in addition to the intermediate positions as well as before the 1st country and after the last of the buttons to select a position
//RankingDisplayer is signed as follows:
//
//@Composable
//fun RankingDisplayer(data: List<CountryValue>, onClick: ((Int) -> Unit)? = null)
//
//If onClick is null, the variant without intermediate buttons is displayed, otherwise the buttons are displayed and onClick is called when one is clicked. The index passed as a parameter to onClick corresponds to the chosen insertion position (ranging from 0 to data.size if added last).

@Composable
fun RankingDisplayer(data: List<CountryValue>, onClick: ((Int) -> Unit)? = null) {
    LazyColumn(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (onClick == null) {
            items(data.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    CountryDisplayer(
                        code = data[index].code,
                        name = data[index].name,
                        value = data[index].value
                    )
                }
            }
        } else {
            items(data.size) { index ->
                Button(
                    onClick = {
                        val id = if (index > 0) index -1 else index
                        onClick.invoke(id)
                    }
                ) {
                    Text("Place here")
                }
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CountryDisplayer(
                        code = data[index].code,
                        name = data[index].name,
                        value = data[index].value
                    )
                }
                Button(onClick = { onClick.invoke(index + 1) }) {
                    Text("Place here")
                }
            }
        }
    }
}