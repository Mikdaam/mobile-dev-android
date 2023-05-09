package fr.android.locationlogger.ui.location

import android.location.Location
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import fr.android.locationlogger.data.Geolocation

@Composable
fun LocationListDisplayer(locations: List<Geolocation>) {
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
