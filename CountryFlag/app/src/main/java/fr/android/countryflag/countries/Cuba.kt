package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Preview(widthDp = 800, heightDp = 400)
@Composable
fun CubaFlag() {

    val triangleShape = GenericShape { size, _ ->
        val halfWidth = size.width / 2
        val squareHalfWidth = halfWidth * halfWidth
        val xLength =
            sqrt((squareHalfWidth - ((size.width / 4) * (size.width / 4))))
        moveTo(0f, 0f)
        lineTo(xLength, size.height / 2)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
        close()
    }
    val starShape = GenericShape { size, _ ->
        val centerX = ((size.width / 8) / cos(30 * Math.PI / 180)).toFloat()
        val centerY = size.height / 2
        val outerRadius = size.height * 3 / 20
        val innerRadius = outerRadius * (5f / 13)
        val branchCount = 5
        val c = (Math.PI / 2).toFloat()
        val alpha = (Math.PI * 2 / branchCount).toFloat()
        moveTo(centerX, centerY - outerRadius)
        for (i in 1 until branchCount) {
            val innerAngle = alpha * (i - 0.5f) + c
            val outerAngle = alpha * i + c
            lineTo(
                centerX + cos(innerAngle) * innerRadius,
                centerY - sin(innerAngle) * innerRadius
            )
            lineTo(
                centerX + cos(outerAngle) * outerRadius,
                centerY - sin(outerAngle) * outerRadius
            )
        }
        val innerAngle = alpha * (4.5f) + c
        lineTo(
            centerX + cos(innerAngle) * innerRadius,
            centerY - sin(innerAngle) * innerRadius
        )
        close()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 5f, fill = true)
                    .background(color = Color.Blue)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 5f, fill = true)
                    .background(color = Color.White)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 5f, fill = true)
                    .background(color = Color.Blue)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 5f, fill = true)
                    .background(color = Color.White)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 5f, fill = true)
                    .background(color = Color.Blue)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red, shape = triangleShape)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, shape = starShape)
        )

    }
}

object Cuba : Country(
    "Cuba",
    11_032_343,
    110_860f,
    103.1f,
    2.76f,
    11.06f,
    2.63f,
    { CubaFlag() })