package fr.android.locationlogger

import android.text.format.DateUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun LocationDisplayer(time: Long, latitude: Double, longitude: Double) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Longitude : $longitude")
        Text(text = "Latitude : $latitude")
        Text(text = "Time : ${DateUtils.formatDateTime(LocalContext.current, time, DateUtils.FORMAT_SHOW_TIME)}")
    }
}