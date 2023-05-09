package fr.android.locationlogger.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Geolocation::class], version = 1)
abstract class LocationDatabase: RoomDatabase() {
    abstract fun geolocationDAO(): GeolocationDAO

    companion object {
        private const val DATABASE_NAME = "location_database"

        @Volatile
        private var INSTANCE: LocationDatabase? = null

        fun getInstance(context: Context): LocationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    LocationDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}