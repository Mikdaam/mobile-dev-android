package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview(widthDp = 800, heightDp = 400)
@Composable
fun CoteDIvoireFlag() {
    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = Color(0xF3, 0x79, 0x05))
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = Color.White)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = Color(0x5A, 0xB5, 0x32))
        )
    }
}

object CoteDIvoire : Country("Côte d'Ivoire",
    29_389_150,
    322_462f,
    61.502f,
    3.47f,
    12.66f,
    13.232f,
    { CoteDIvoireFlag() })