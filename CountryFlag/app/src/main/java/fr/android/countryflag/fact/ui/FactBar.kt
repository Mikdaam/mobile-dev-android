package fr.android.countryflag.fact.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.ui.theme.QuickSand

@Composable
fun FactBar(ratio: Float, text: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                if (ratio > 0) {
                    Box(
                        modifier = Modifier
                            .weight(ratio)
                            .fillMaxSize()
                            .background(Color(0xFFFFFACF))
                    )
                }
                if (1-ratio > 0) {
                    Box(
                        modifier = Modifier
                            .background(Color(0x5EFFFACF))
                            .fillMaxSize()
                            .weight(1 - ratio)
                    )
                }
            }

            Text(
                text = text,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                color = Color(0xFF454545),
                fontFamily = QuickSand,
                fontSize = 10.sp,
            )
        }
    }
}