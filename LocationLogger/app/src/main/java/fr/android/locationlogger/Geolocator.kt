package fr.android.locationlogger

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.core.app.ActivityCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Geolocator() {
    val context = LocalContext.current
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    val locationList by LocationCache.locationList.collectAsState()

    DisposableEffect(Unit) {
        val locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                LocationCache.addLocation(location)
            }

            override fun onProviderDisabled(provider: String) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onStatusChanged(provider: String, status: Int, extras: Bundle?) {}
        }

        val hasPermission = permissionState.status.isGranted
        if (hasPermission) {
            try {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
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
        if (permissionState.status.isGranted) {
            LocationListDisplayer(locations = locationList.take(MAX_LOCATIONS))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Geolocation permission denied")
                Button(onClick = { permissionState.launchPermissionRequest() }) {
                    Text("Grant permission")
                }
            }
        }
    }
}

private const val MAX_LOCATIONS = 10



