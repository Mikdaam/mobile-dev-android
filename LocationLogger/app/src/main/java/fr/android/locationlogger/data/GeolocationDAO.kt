package fr.android.locationlogger.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GeolocationDAO {
    @Insert
    fun saveLocation(geolocation: Geolocation)

    @Delete
    fun deleteLocation(geolocation: Geolocation)

    @Query("SELECT * FROM geolocation")
    fun getAllLocations(): Flow<List<Geolocation>>
}