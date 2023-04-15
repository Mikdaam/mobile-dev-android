package fr.android.countryflag.others

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import fr.android.countryflag.R

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
