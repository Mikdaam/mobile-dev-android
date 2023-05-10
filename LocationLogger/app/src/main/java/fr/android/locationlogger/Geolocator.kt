package fr.android.locationlogger

import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import fr.android.locationlogger.data.Geolocation
import fr.android.locationlogger.data.LocationDatabase
import fr.android.locationlogger.ui.location.LocationDisplayer
import fr.android.locationlogger.ui.location.LocationListDisplayer

@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Geolocator(context: Context) {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    val db = LocationDatabase.getInstance(context)
    val locationDAO = db.geolocationDAO()

    var location by remember{mutableStateOf(Location(LocationManager.FUSED_PROVIDER))}
    //val locationList by LocationCache.locationList.collectAsState()

    DisposableEffect(Unit) {
        val locationListener = LocationListener {
            location = it
            Log.d("Geolocator", "Location received: $it")
            locationDAO.saveLocation(Geolocation(time = it.time, latitude = it.latitude, longitude = it.longitude))
        }

        val hasPermission = permissionState.status.isGranted
        if (hasPermission) {
            try {
                locationManager.requestLocationUpdates(LocationManager.FUSED_PROVIDER, 10_000L, 2f, locationListener)
            } catch (e: SecurityException) {
                // Handle the case where the permission was revoked by the user or the system
                Log.e("Geolocator", "Permission revoked")
            }
        } else {
            if (permissionState.status.shouldShowRationale) {
                // Display a rationale message to the user before requesting the permission

            } else {
                // Request the permission using the permissionState
                permissionState.launchPermissionRequest()
            }
        }

        onDispose {
            try {
                locationManager.removeUpdates(locationListener)
            } catch (e: SecurityException) {
                // Handle the case where the permission was revoked by the user or the system
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Geo locator") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (permissionState.status.isGranted) {
                Text(text = "Current location")
                LocationDisplayer(
                    time = location.time,
                    latitude = location.latitude,
                    longitude = location.longitude
                )
                Divider()
                LocationListDisplayer(locations = locationDAO.getAllLocations().collectAsState(initial = emptyList()).value.takeLast(MAX_LOCATIONS))
            } else {
                Text("Geolocation permission denied")
                Button(onClick = { permissionState.launchPermissionRequest() }) {
                    Text("Grant permission")
                }
            }
        }
    }
}

private const val MAX_LOCATIONS = 10



