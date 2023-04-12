package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview
@Composable
fun GreecFlag() {
    Column(modifier = Modifier.fillMaxSize().background(Color(13,94,175))) {
        Row(modifier = Modifier.fillMaxWidth().weight(1F / 2F, fill = true)) {
            Box(modifier = Modifier.fillMaxHeight().weight(1F/3F, fill = true)) {
                Column() {
                    Box(Modifier.fillMaxWidth().weight(1F/3F, fill = true))
                    Box(Modifier.fillMaxWidth().weight(1F/6F, fill = true).background(Color.White))
                    Box(Modifier.fillMaxWidth().weight(1F/3F, fill = true))
                }
                Row() {
                    Box(Modifier.fillMaxWidth().weight(1F/3F, fill = true))
                    Box(Modifier.fillMaxHeight().weight(1F/6F, fill = true).background(Color.White))
                    Box(Modifier.fillMaxWidth().weight(1F/3F, fill = true))
                }
            }
            Column(modifier = Modifier.fillMaxWidth().weight(2F/3F, fill = true)) {
                Box(Modifier.fillMaxWidth().weight(1F/5F, fill = true))
                Box(Modifier.fillMaxWidth().weight(1F/5F, fill = true).background(Color.White))
                Box(Modifier.fillMaxWidth().weight(1F/5F, fill = true))
                Box(Modifier.fillMaxWidth().weight(1F/5F, fill = true).background(Color.White))
                Box(Modifier.fillMaxWidth().weight(1F/5F, fill = true))
            }
        }
        Column(modifier = Modifier.fillMaxWidth().weight(1F/2F, fill = true)) {
            Box(Modifier.fillMaxWidth().weight(1F/4F, fill = true).background(Color.White))
            Box(Modifier.fillMaxWidth().weight(1F/4F, fill = true))
            Box(Modifier.fillMaxWidth().weight(1F/4F, fill = true).background(Color.White))
            Box(Modifier.fillMaxWidth().weight(1F/4F, fill = true))
        }
    }
}

object Greece : Country(
    "Grèce",
    10497595, //hab
    131.957f, //km²
    314.427f, //Milliards de $
    14.8f, //%
    103.532f, //Milliards de $
    87.521f, //Milliards de $
    { GreecFlag() }
)