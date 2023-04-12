package fr.android.countryflag.countries

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

@Composable
fun KuwaitFlag() {
  val trapeziumShape = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width / 4, size.height / 3)
    lineTo(size.width / 4, size.height / 3 + size.height / 3)
    lineTo(0f, size.height)
    close()
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .border(width = Dp.Hairline, color = Color.Black)
  ) {
    Column(Modifier.fillMaxSize()) {
      Box(
        Modifier
          .fillMaxWidth()
          .background(color = Color.Green)
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
          .background(color = Color.Red)
          .weight(1f / 3f, fill = true)
      )
    }
    Box(
      Modifier
        .fillMaxSize()
        .background(color = Color.Black, shape = trapeziumShape)
    )
  }
}

object Kuwait : Country(
  "Kuwait",
  3103580, // real value
  17818f, // sq km
  191.522f, // billion dollars
  3.71f, // %
  48.954f, // billion dollars
  77.121f, // billion dollars
  { KuwaitFlag() }
)
