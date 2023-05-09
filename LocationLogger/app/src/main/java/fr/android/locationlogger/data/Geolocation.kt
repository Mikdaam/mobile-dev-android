package fr.android.locationlogger.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Geolocation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val time: Long,
    val latitude: Double,
    val longitude: Double
)