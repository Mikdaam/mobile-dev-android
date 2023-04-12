package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview
@Composable
fun LituanianFlag() {
    Column(modifier = Modifier.fillMaxSize().background(Color(0, 106, 68))) {
        Box(modifier = Modifier.fillMaxWidth().weight(1F/3F, fill=true).background(Color(253, 185, 19)))
        Box(modifier = Modifier.fillMaxWidth().weight(1F/3F, fill=true))
        Box(modifier = Modifier.fillMaxWidth().weight(1F/3F, fill=true).background(Color(139, 39, 45)))
    }
}

object Lithuania : Country(
    "Lituanie",
    2655755, //hab
    65300f, //km²
    110.089f, //milliards de $
    7.9f, // %
    50.377f, //milliards de $
    53.397f, //milliards de $
    { LituanianFlag() }
)