package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

@Composable
fun QatarFlag() {
    val triangleShape = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width, size.height / 2)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
        close()
    }


    Row(modifier= Modifier
        .fillMaxSize()
        .border(width = Dp.Hairline, color = Color.Black)) {
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(color = android.graphics.Color.parseColor("#FFFFFF")))
                .weight(1f / 3f, fill = true)
        ) {}
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(color = android.graphics.Color.parseColor("#8A1538")))
                .weight(2f / 3f, fill = true)
        ) {
            Row(Modifier.fillMaxSize()) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f / 6f)
                ) {
                    repeat(9) {
                        Box(Modifier.fillMaxWidth().weight(1f/9f, fill=true).background(color= Color.White, shape=triangleShape))
                    }
                }
                Box(
                    Modifier
                        .fillMaxHeight()
                        .weight(2f / 3f, fill = true)
                ) {}
            }
        }
    }
}

object Qatar: Country(
    name = "Qatar",
    population = 2_532_104,
    area = 11_586f, // Square Kilometers
    gdp = 249.636f, // billion $
    unemployment = 0.26f, // percentage %
    imports = 61.204f, // billion $
    exports = 105.549f, // billion $
    flag = { QatarFlag() }
)
