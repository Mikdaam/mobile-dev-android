package fr.android.countryflag.countries

import androidx.compose.runtime.Composable;

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country


@Composable
fun FrenchFlag() {
    val myBlueColor = Color(android.graphics.Color.parseColor("#001D6E"));
    val myWhiteColor = Color(android.graphics.Color.parseColor("#FFFFFF"));

    val myRedColor = Color(android.graphics.Color.parseColor("#E6001F"));

    Box(modifier = Modifier.aspectRatio(ratio = 1.5F).border(2.dp, Color.Black, shape = RectangleShape)) {
        Row(Modifier.fillMaxSize()) {
            Box(Modifier.fillMaxHeight().weight(1f / 3f, fill = true).background(color = myBlueColor))
            Box(Modifier.fillMaxHeight().weight(1f / 3f, fill = true).background(color = myWhiteColor))
            Box(Modifier.fillMaxHeight().weight(1f / 3f, fill = true).background(color = myRedColor))
        }
    }
}

object France: Country(
        "France",
        68521974,
        643801f,
        12.2f,
        8.06f,
        9.5771699E8f,
        920.864000f,
        { FrenchFlag() }
        )