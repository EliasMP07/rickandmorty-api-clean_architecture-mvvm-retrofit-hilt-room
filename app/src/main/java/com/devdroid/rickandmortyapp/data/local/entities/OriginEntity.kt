package com.devdroid.rickandmortyapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devdroid.rickandmortyapp.data.remote.model.Origin

@Entity(
    tableName = "origin_table"
)
data class OriginEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_origin") var id: Int = 0,
    @ColumnInfo("name") var name: String?,
    @ColumnInfo("url") var url: String?
)

fun Origin.toDatabase() = OriginEntity(
    name = name,
    url = url
)