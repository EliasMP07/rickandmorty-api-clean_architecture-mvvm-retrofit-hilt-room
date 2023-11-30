package com.devdroid.rickandmortyapp.domain.model

import com.devdroid.rickandmortyapp.data.local.entities.CharacterEntity
import com.devdroid.rickandmortyapp.data.remote.model.Character

data class CharacterItem(
    var gender: String?,
    var id: Int?,
    var image: String?,
    var name: String?,
    var species: String?,
    var origin: OriginItem? = OriginItem(),
    var location: LocationItem? = LocationItem(),
    var status: String?,
    var type: String?,
    var favorite: Boolean = false

    )

fun Character.toDomain() = CharacterItem(
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    origin = origin!!.toDomain(),
    location = location!!.toDomain(),
    status = status,
    type = type
)

fun CharacterEntity.toDomain() = CharacterItem(
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type,
    favorite = favorite
)