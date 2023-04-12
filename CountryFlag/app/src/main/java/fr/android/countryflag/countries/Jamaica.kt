package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import fr.android.countryflag.countries.Country

@Composable
fun JamaicaFlag() {
    val blackTriangleShape1 = GenericShape { size, layoutDirection ->
        moveTo(0f, (0.5f/12f) * size.height)
        lineTo(size.width - ((0.5f/12f) * size.width), size.height / 2)
        lineTo(0f, size.height - (0.5f/12f) * size.height)
        close()
    }
    val blackTriangleShape2 = GenericShape { size, layoutDirection ->
        moveTo(size.width, (0.5f/12f) * size.height)
        lineTo((0.5f/12f) * size.width, size.height / 2)
        lineTo(size.width, size.height - (0.5f/12f) * size.height)
        close()
    }

    val greenTriangleShape1 = GenericShape { size, layoutDirection ->
        moveTo((0.5f/12f) * size.width, size.height)
        lineTo(size.width / 2, (size.height / 2) + (0.5f/12f) * size.height)
        lineTo(size.width - (0.5f/12f) * size.width, size.height)
        close()
    }
    val greenTriangleShape2 = GenericShape { size, layoutDirection ->
        moveTo((0.5f/12f) * size.width, 0f)
        lineTo(size.width / 2, (size.height / 2) - (0.5f/12f) * size.height)
        lineTo(size.width - (0.5f/12f) * size.width, 0f)
        close()
    }

    Box(modifier= Modifier
        .fillMaxSize()
        .background(color = Color("#FFB915".toColorInt()))) {
        Row(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f / 2f, fill = true)
                    .background(color = Color.Black, shape = blackTriangleShape1))
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f / 2f, fill = true)
                    .background(color = Color.Black, shape = blackTriangleShape2))
        }

        Row(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .background(color = Color("#007847".toColorInt()), shape = greenTriangleShape1))
        }

        Row(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .background(color = Color("#007847".toColorInt()), shape = greenTriangleShape2))
        }
    }
}

object Jamaica: Country(
    "Jamaica",
    2_820_982, // millions
    10.991f, // milliers km²
    15.847f, // milliards $
    9.18f, // %
    7.414f, // milliards $
    4.385f, // milliards $
    { JamaicaFlag() }
)
