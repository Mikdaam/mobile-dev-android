package fr.android.countryflag.countries

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

@Composable
fun NetherlandsFlag() {
  Column(Modifier.border(width = Dp.Hairline, color = Color.Black)) {
    Box(
      Modifier
        .fillMaxWidth()
        .background(color = Color.Red)
        .weight(1f / 3f, fill = true)
    )
    Box(
      Modifier
        .fillMaxWidth()
        .background(color = Color.White)
        .weight(1f / 3f, fill = true)
    )
    Box(
      Modifier
        .fillMaxWidth()
        .background(color = Color.Blue)
        .weight(1f / 3f, fill = true)
    )
  }
}

object Netherlands : Country(
  "Netherlands",
  17463930, // real value
  41543f, // sq km
  992.675f, // billion dollars
  4.01f, // %
  735.7f, // billion dollars
  839.6f, // billion dollars
  { NetherlandsFlag() }
)
