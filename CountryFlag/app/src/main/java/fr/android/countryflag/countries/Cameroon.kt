package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CameroonFlag() {
    val starShape = GenericShape { size, _ ->
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

    Row(modifier= Modifier
        .fillMaxSize()
        .border(width = Dp.Hairline, color = Color.Black)) {
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(color = android.graphics.Color.parseColor("#00A651")))
                .weight(1f / 3f, fill = true)
        ) {}
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(color = android.graphics.Color.parseColor("#ED1C24")))
                .weight(1f / 3f, fill = true)
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(color = android.graphics.Color.parseColor("#FFF205")),
                        shape = starShape
                    )
            )
        }
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(color = android.graphics.Color.parseColor("#FFF200")))
                .weight(1f / 3f, fill = true)
        ) {}
    }
}

object Cameroon: Country(
    name = "Cameroon",
    population = 30_135_732,
    area = 475_440f, // Square Kilometers
    gdp = 100.648f, // billion $
    unemployment = 3.87f, // percentage %
    imports = 9.027f, // billion $
    exports = 7.449f, // billion $
    flag = { CameroonFlag() }
)