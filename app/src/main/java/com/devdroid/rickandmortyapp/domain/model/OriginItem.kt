package com.devdroid.rickandmortyapp.domain.model

import com.devdroid.rickandmortyapp.data.local.entities.OriginEntity
import com.devdroid.rickandmortyapp.data.remote.model.Origin

data class OriginItem(
    val name: String? = "",
    val url: String? = ""
)

fun Origin.toDomain() = OriginItem(
    name = name,
    url = url
)

fun OriginEntity.toDomain() = OriginItem(
    name = name,
    url = url
)