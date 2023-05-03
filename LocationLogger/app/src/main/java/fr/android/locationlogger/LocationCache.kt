package fr.android.locationlogger

import android.location.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object LocationCache {
    private val _locationList = MutableStateFlow<List<Location>>(emptyList())

    val locationList: StateFlow<List<Location>>
        get() = _locationList.asStateFlow()

    fun addLocation(location: Location) {
        _locationList.update { locations ->
            val updatedLocations = mutableListOf(location)
            updatedLocations.addAll(locations.take(MAX_LOCATION_COUNT - 1))
            updatedLocations
        }
    }

    private const val MAX_LOCATION_COUNT = 10
}
