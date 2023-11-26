package com.devdroid.rickandmortyapp.domain.model

import com.devdroid.rickandmortyapp.data.local.entities.CharacterEntity
import com.devdroid.rickandmortyapp.data.remote.model.Character

data class CharacterItem(
    val created: String?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val name: String?,
    val species: String?,
    var location: LocationItem? = LocationItem(),
    val status: String?,
    val type: String?,
    val url: String?,

    )

fun Character.toDomain() = CharacterItem(
    created = created,
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    location = location!!.toDomain(),
    status = status,
    type = type,
    url = url,
)

fun CharacterEntity.toDomain() = CharacterItem(
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