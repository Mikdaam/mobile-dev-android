package fr.android.chronogame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.android.chronogame.chrono.ChronoGame
import fr.android.chronogame.chrono.ChronometerManager
import fr.android.chronogame.ui.theme.ChronoGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChronoGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //ChronometerManager()
                    var result by remember { mutableStateOf("Play for now!") }

                    ChronoGame(
                        expectedDuration = 5_000,
                        onVerdict = {
                            if (it != 5_000L) {
                                result = "You can do better"
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChronoGameTheme {

    }
}