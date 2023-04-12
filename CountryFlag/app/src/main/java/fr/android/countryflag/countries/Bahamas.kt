package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country
import kotlin.math.sqrt

@Composable
fun BahamasFlag() {
    val triangleShape = GenericShape { size, layoutDirection ->
        moveTo(0f, 0f)
        lineTo(size.width, size.height / 2)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
        close()
    }
    Box(modifier = Modifier.size(width = 400.dp, height = 200.dp)) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f, fill = true)
                    .background(Color(red = 0, green = 119, blue = 139, alpha = 255))
            ) { }
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f, fill = true)
                    .background(Color(red = 255, green = 199, blue = 44, alpha = 255))
            ) { }
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f, fill = true)
                    .background(Color(red = 0, green = 119, blue = 139, alpha = 255))
            ) { }
        }
        Row(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(sqrt(6.75f) / 6f, fill = true)
                    .background(color = Color.Black, shape = triangleShape)
            )
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight((6 - sqrt(6.75f)) / 6f, fill = true)
                    .background(color = Color.Transparent)
            )
        }
    }
}

object Bahamas: Country(
    "Bahamas",
    358508,
    13880f,
    12.323f,
    13.24f,
    4.924f,
    3.202f,
    { BahamasFlag() }
)