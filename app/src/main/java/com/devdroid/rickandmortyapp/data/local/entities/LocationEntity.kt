package com.devdroid.rickandmortyapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devdroid.rickandmortyapp.data.remote.model.Location

@Entity(
    tableName = "location_table"
)
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_location") var id: Int = 0,
    @ColumnInfo("name") var name: String?,
    @ColumnInfo("url") var url: String?
)


fun Location.toDatabase() = LocationEntity(
    name = name,
    url = url
)