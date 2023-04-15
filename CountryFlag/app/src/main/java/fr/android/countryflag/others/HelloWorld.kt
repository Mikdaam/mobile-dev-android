package fr.android.countryflag.others

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HelloWorld(name: String) {
    Column(
        modifier = Modifier.padding(10.dp),
    ) {
        val content = LocalContext.current
        var counter by remember { mutableStateOf(0) }

        Greetings(name = name, counter = counter)
        WorldMap(click = {
            Toast.makeText(content, "You are an adventurer, Go visit the world.", Toast.LENGTH_SHORT).show()
            counter += it
        })
    }
}

@Composable
fun Greetings(name: String, counter: Int) {
    Text(
        textAlign = TextAlign.Center,
        text = "Hello $name.\nThere is $counter clicks on the map. 😘❤️👌✅"
    )
}
