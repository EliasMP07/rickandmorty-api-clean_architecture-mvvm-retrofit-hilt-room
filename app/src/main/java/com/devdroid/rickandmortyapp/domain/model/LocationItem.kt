package com.devdroid.rickandmortyapp.domain.model

import com.devdroid.rickandmortyapp.data.local.entities.LocationEntity
import com.devdroid.rickandmortyapp.data.remote.model.Location

data class LocationItem(
    val name: String? = "",
    val url: String? = ""
)

fun Location.toDomain() = LocationItem(
    name = name,
    url = url
)

fun LocationEntity.toDomain() = LocationItem(
    name = name,
    url = url
)