package fr.android.locationlogger

import android.location.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object LocationCache {
    private val _locationList = MutableStateFlow<List<Location>>(emptyList())
    val locationList = _locationList.asStateFlow()
    fun addLocation(location: Location) {
        _locationList.update { locations -> locations + location }
    }
}
