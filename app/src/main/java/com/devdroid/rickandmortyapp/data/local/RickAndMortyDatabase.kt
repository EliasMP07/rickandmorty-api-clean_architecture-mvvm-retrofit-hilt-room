package com.devdroid.rickandmortyapp.data.local

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.devdroid.rickandmortyapp.data.local.dao.CharacterDao
import com.devdroid.rickandmortyapp.data.local.entities.CharacterEntity
import com.devdroid.rickandmortyapp.data.local.entities.LocationEntity
import com.devdroid.rickandmortyapp.data.local.entities.OriginEntity

@Database(
    entities = [
        CharacterEntity::class,
        LocationEntity::class,
        OriginEntity::class
    ],
    version = 1,
    exportSchema = false

)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}