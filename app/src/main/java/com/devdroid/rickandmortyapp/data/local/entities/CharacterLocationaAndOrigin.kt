package com.devdroid.rickandmortyapp.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterLocationaAndOrigin(
    @Embedded val character: CharacterEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_location",
    )
    val location: LocationEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_origin",
    )
    val origin: OriginEntity
)
