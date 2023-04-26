package fr.android.locationlogger

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat


@Composable
fun Geolocator() {
    val context = LocalContext.current
    var location by remember { mutableStateOf<Location?>(null) }
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    DisposableEffect(true) {
        val listener = LocationListener { location = it }
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                101
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, listener)
        Log.d("GPS Enabled", "GPS Enabled");

        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        onDispose {
            locationManager.removeUpdates(listener)
        }
    }

    if (location != null) {
        Text(text = location?.toString() ?: "No location available")
        LocationDisplayer(time = location!!.time, latitude = location!!.latitude, longitude = location!!.longitude)
    }
}