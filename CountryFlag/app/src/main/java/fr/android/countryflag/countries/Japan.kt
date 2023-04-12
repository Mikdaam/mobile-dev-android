package fr.android.countryflag.countries

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

/*
README !!!
Don't worry if the flag is wierd on a phone screen, it's because the diameter of the circle is 3/5 (= 0.6) of the height of the box...
This flag is meant to have a ratio of 2 units high and 3 units wide.
*/
@Composable
fun JapanFlag() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Color.White)
      .border(width = Dp.Hairline, color = Color.Black),
    contentAlignment = Alignment.Center
  ) {
    Box(
      Modifier
        .fillMaxHeight(0.6f)
        .aspectRatio(1f)
        .background(color = Color.Red, shape = CircleShape)
    )
  }
}

object Japan : Country(
  "Japan",
  123719238, // real value
  377915f, // sq km
  5126.0f, // billion dollars
  2.8f, // %
  941.671F, // billion dollars
  919.158F, // billion dollars
  { JapanFlag() }
)
