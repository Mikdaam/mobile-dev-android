package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

object VietnamFalg : Country(
    "Vietnam",
    104799174,//population
    331210f,//area sq km
    1.036f,// gdp trillion $
    2.17f,// unemployment
    338.021f,//imports billion $
    339.984f,// exports billion $
    { VietnamFalg() }
)
    @Preview(showBackground = true)
    @Composable
    fun VietnamFalg(){
        val starShape = GenericShape { size, layoutDirection ->
            val radius = size.minDimension / 4
            val angleDelta = PI.toFloat() / 5
            var angle = PI.toFloat() / 2

            moveTo(
                x = size.width / 2 + radius * cos(angle),
                y = size.height / 2 - radius * sin(angle)
            )

            repeat(6) {
                angle += angleDelta
                lineTo(
                    x = size.width / 2 + radius * cos(angle),
                    y = size.height / 2 + radius * sin(angle)
                )
                angle += angleDelta
                lineTo(
                    x = size.width / 2 + (radius * 5 / 13) * cos(angle),
                    y = size.height / 2 + (radius * 5 / 13) * sin(angle)
                )
            }

            close()

        }
        Column( modifier = Modifier
            .fillMaxSize()
            .border(Dp.Hairline, color = Color.Black)){
            Box(
                Modifier
                    .fillMaxSize()
                    .background(color = Color(205, 33, 42))
                    .background(color = Color(255, 255, 0), shape = starShape)
                    .weight(1f, fill = true)){}

        }

    }
