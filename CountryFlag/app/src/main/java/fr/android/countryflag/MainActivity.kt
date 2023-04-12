package fr.android.countryflag

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.ui.theme.CountryFlagTheme
import fr.android.countryflag.ui.theme.QuickSand

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryFlagTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CountryList()
                }
            }
        }
    }
}

@Composable
fun HelloWorld(name: String) {
    Column(
        modifier = Modifier.padding(10.dp),
    ) {
        val content = LocalContext.current
        var counter by remember { mutableStateOf(0) }

        Greetings(name = name, counter = counter)
        WorldMap(click = {
            Toast.makeText(content, "You are an adventurer, Go visit the world.", Toast.LENGTH_SHORT).show()
            counter += it
        })
    }
}

@Composable
fun Greetings(name: String, counter: Int) {
    Text(
        textAlign = TextAlign.Center,
        text = "Hello $name.\nThere is $counter clicks on the map. 😘❤️👌✅"
    )
}

@Composable
fun WorldMap(click: (value: Int) -> Unit) {
    Image(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onTap = { click.invoke(1) },
                onDoubleTap = { click.invoke(4) }
            )},
        painter = painterResource(id = R.drawable.equirectangular_world_map), 
        contentDescription = "World map",
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun CountryList() {
    Box(Modifier.background(color = Color(0xFFF8F7F7))) {
        LazyColumn {
            items(ALL_COUNTRIES) {country ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max)
                        .padding(5.dp)
                        .background(color = Color(0x68DAF5FF), shape = RoundedCornerShape(5.dp)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier
                        .width(100.dp)
                        .height(50.dp)
                    ) {
                        country.flag.invoke()
                    }
                    Text(
                        text = country.name,
                        color = Color(0xFF454545),
                        fontSize = 16.sp,
                        fontFamily = QuickSand
                    )
                }
                //Divider()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryFlagTheme {
        CountryList()
    }
}