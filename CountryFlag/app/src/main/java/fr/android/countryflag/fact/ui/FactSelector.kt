package fr.android.countryflag.fact.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.android.countryflag.fact.Fact

@Composable
fun FactSelector(fact: Fact, onChange: (Fact) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val facts = Fact.values()

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                fact.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { expanded = true })
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                facts.forEach{ fact ->
                    DropdownMenuItem(onClick = {
                        onChange.invoke(fact)
                        expanded = false
                    }) {
                        Text(text = fact.title)
                    }
                }
            }
        }

        IconButton(onClick = { }) {
            Icon(Icons.Rounded.Refresh, "Sort list")
        }

        IconButton(onClick = {  }) {
            Icon(Icons.Rounded.List, "Change view")
        }
    }
}
