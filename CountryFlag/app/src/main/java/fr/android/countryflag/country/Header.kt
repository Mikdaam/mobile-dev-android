package fr.android.countryflag.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact
import fr.android.countryflag.fact.ui.FactSelector

@Composable
fun Header(
    fact: Fact,
    onChange: (Fact) -> Unit,
    countries: List<Country>,
    onSort: (List<Country>) -> Unit,
    view: Boolean,
    onChangeView: (Boolean) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .weight(1/2f)
        ) {
            FactSelector(fact = fact, onChange = onChange)
        }
        IconButton(onClick = { onSort.invoke(countries.asReversed()) }) {
            Icon(Icons.Rounded.Refresh, "Sort list")
        }

        IconButton(onClick = { onChangeView.invoke(!view) }) {
            Icon(Icons.Rounded.List, "Change view")
        }
    }
}