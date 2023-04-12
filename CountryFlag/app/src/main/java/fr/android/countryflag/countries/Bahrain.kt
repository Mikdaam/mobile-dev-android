package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview(showBackground = true)
@Composable
fun BahrainFlag() {
    val triangleShape = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width, size.height / 2)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
        close()
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .weight(2f / 5f, fill = true)
        ) {
            Row(
                Modifier.fillMaxWidth()
            ) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(2f / 3f, fill = true)
                        .background(Color.White)
                ) { }
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f / 3f, fill = true)
                        .background(Color(red = 0xCE, green = 0x11, blue = 0x26, alpha = 0xFF))
                ) {
                    repeat(5) {
                        Box(Modifier.fillMaxWidth().weight(1f/5f, fill=true).background(color=Color.White, shape=triangleShape))
                    }
                }
            }
        }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(3f / 5f, fill = true)
                .background(Color(red = 0xCE, green = 0x11, blue = 0x26, alpha = 0xFF))) { }
    }
}

object Bahrain: Country(
        "Bahrain",
    1553886,
    760f, //sq km
    72.267f, //billion
        1.87f, //%
        27.187f, //billion
        30.097f, //billion
        { BahrainFlag() }
    )