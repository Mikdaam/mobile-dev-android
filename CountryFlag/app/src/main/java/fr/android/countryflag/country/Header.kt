package fr.android.countryflag.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
    listView: Boolean,
    onChangeView: (Boolean) -> Unit,
    descendingOrder: Boolean,
    changeOrder: (Boolean) -> Unit
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
        val sorted = if (descendingOrder) {
            countries.sortedBy { fact.extractor(it) }
        } else {
            countries.sortedByDescending { fact.extractor(it) }
        }

        IconButton(onClick = { onSort.invoke(sorted); changeOrder(!descendingOrder) }) {
            Icon(Icons.Rounded.Refresh, "Sort list")
        }

        IconButton(onClick = { onChangeView.invoke(!listView) }) {
            Icon(
                if (listView) Icons.Rounded.Clear else Icons.Rounded.List,
                "Change listView"
            )
        }
    }
}