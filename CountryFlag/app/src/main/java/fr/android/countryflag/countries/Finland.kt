package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun FinlandFlag() {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth().weight(4f/11f)
        ) {
            Box(Modifier
                .fillMaxHeight()
                .background(Color(0xFFFFFFFF))
                .weight(5f / 18f, fill = true)) {  }
            Box(Modifier
                .fillMaxHeight()
                .background(Color(0xFF003580))
                .weight(3f / 18f, fill = true)) {  }
            Box(Modifier
                .fillMaxHeight()
                .background(Color(0xFFFFFFFF))
                .weight(10f / 18f, fill = true)) {  }
        }
        Row(Modifier.fillMaxWidth().background(Color(0xFF003580)).weight(3f/11f, fill = true)) {}
        Row(Modifier.fillMaxWidth().weight(4f/11f)) {
            Box(Modifier
                .fillMaxHeight()
                .background(Color(0xFFFFFFFF))
                .weight(5f / 18f, fill = true)) {  }
            Box(Modifier
                .fillMaxHeight()
                .background(Color(0xFF003580))
                .weight(3f / 18f, fill = true)) {  }
            Box(Modifier
                .fillMaxHeight()
                .background(Color(0xFFFFFFFF))
                .weight(10f / 18f, fill = true)) {  }
        }
    }
}

object Finland: Country(
    "Finland",
    5614571,
    338145f,
    270.143f,
    6.8f,
    116.277f,
    116.905f,
    { FinlandFlag() }
)
