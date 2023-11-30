package com.devdroid.rickandmortyapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.devdroid.rickandmortyapp.data.remote.model.Character
import com.devdroid.rickandmortyapp.domain.model.CharacterItem

@Entity(
    tableName = "character_table"

    )
data class CharacterEntity(
    @ColumnInfo("gender")var gender: String? = "",
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo("id") var id: Int? = 0,
    @ColumnInfo("image")var image: String?,
    @ColumnInfo("name")var name: String? = "",
    @ColumnInfo("species")var species: String? = "",
    @ColumnInfo("status") var status: String? = "",
    @ColumnInfo("type")var type: String? = "",
    @ColumnInfo("favorite")var favorite: Boolean = false

)

fun Character.toDatabase() = CharacterEntity(
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type)

fun CharacterItem.toDatabase() = CharacterEntity(
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type,
    favorite = favorite

)