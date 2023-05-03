package fr.android.locationlogger

import android.location.Location
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun LocationListDisplayer(locations: List<Location>) {
    LazyColumn {
        items(locations) { location ->
            LocationDisplayer(
                time = location.time,
                latitude = location.latitude,
                longitude = location.longitude
            )
        }
    }
}
