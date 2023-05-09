package fr.android.locationlogger.ui.location

import android.text.format.DateUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LocationDisplayer(
    time: Long,
    latitude: Double,
    longitude: Double
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0x6AE0E0E0)),
    ) {
        Text(
            text = "Latitude: $latitude",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Longitude: $longitude",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Time: ${DateUtils.formatDateTime(
                LocalContext.current,
                time,
                DateUtils.FORMAT_SHOW_TIME or DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )}"
        )
    }
}