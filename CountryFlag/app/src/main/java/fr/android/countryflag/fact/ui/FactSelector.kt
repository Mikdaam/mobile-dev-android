package fr.android.countryflag.fact.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import fr.android.countryflag.fact.Fact

@Composable
fun FactSelector(fact: Fact, onChange: (Fact) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val facts = Fact.values()

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
}
