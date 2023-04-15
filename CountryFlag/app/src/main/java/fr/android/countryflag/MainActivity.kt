package fr.android.countryflag

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact
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
                    CountryFactList(ALL_COUNTRIES, )
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
fun CountryFactListItem(country: Country, index: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(5.dp)
            .background(color = Color(0x68DAF5FF), shape = RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "#$index",
            color = Color(0xFF454545),
            fontSize = 20.sp,
            fontFamily = QuickSand,
            fontStyle = FontStyle.Italic
        )
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
}

@Composable
fun FactSelector(fact: Fact, onChange: (Fact) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val facts = Fact.values();

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                fact.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { expanded = true })
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                facts.forEach{ fact ->
                    DropdownMenuItem(onClick = {
                        onChange.invoke(fact)
                        expanded = false
                    }) {
                        Text(text = fact.title)
                    }
                }
            }
        }

        IconButton(onClick = { }) {
            Icon(Icons.Rounded.Refresh, "Sort list")
        }

        IconButton(onClick = {  }) {
            Icon(Icons.Rounded.List, "Change view")
        }
    }
}

@Composable
fun FactBar() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.LightGray))
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
                            .background(Color.Green)
                    )
                }
                if (1-ratio > 0) {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
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
                color = Color.Black
            )
        }
    }
}

@Composable
fun CountryFactList(countries: List<Country>, fact: Fact) {
    val sortedCountry = countries.sortedByDescending { fact.extractor(it) }
    Box(Modifier.background(color = Color(0xFFF8F7F7))) {
        LazyColumn {
            itemsIndexed(sortedCountry) {id, country ->
                CountryFactListItem(country = country, index = id)
                //Divider()
            }
        }
    }
}

@Composable
fun CountryFactGridItem(country: Country, index: Int) {
    Box(Modifier.height(100.dp)) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "#$index",
                    color = Color(0xFF454545),
                    fontSize = 16.sp,
                    fontFamily = QuickSand,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = country.name,
                    color = Color(0xFF454545),
                    fontSize = 20.sp,
                    fontFamily = QuickSand
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
            ) {
                country.flag.invoke()
            }
            Text(
                text = "${country.population} people",
                color = Color(0xFF454545),
                fontSize = 20.sp,
                fontFamily = QuickSand,
            )
        }
    }
}

@Composable
fun CountryFactGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        itemsIndexed(ALL_COUNTRIES) {index, country ->
            CountryFactGridItem(country = country, index = index)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryFlagTheme {
        CountryFactList()
    }
}