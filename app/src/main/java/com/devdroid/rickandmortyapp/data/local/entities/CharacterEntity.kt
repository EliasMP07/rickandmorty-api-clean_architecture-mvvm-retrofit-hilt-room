package com.devdroid.rickandmortyapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.devdroid.rickandmortyapp.data.remote.model.Character

@Entity(tableName = "character_table")
data class CharacterEntity(
    @ColumnInfo("created")var created: String? = "",
    @ColumnInfo("gender")var gender: String? = "",
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo("id") var id: Int? = 0,
    @ColumnInfo("image")var image: String?,
    @ColumnInfo("name")var name: String? = "",
    @ColumnInfo("species")var species: String? = "",
    @ColumnInfo("status") var status: String? = "",
    @ColumnInfo("type")var type: String? = "",
    @ColumnInfo("url")var url: String? = ""
)

fun Character.toDatabase() = CharacterEntity(
    created = created,
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type,
    url = url
)
