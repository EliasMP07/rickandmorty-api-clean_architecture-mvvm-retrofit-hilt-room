package com.devdroid.rickandmortyapp.domain.repository

import com.devdroid.rickandmortyapp.domain.model.CharacterItem

interface RickAndMortyRepository {


    suspend fun getCharacterOffline(): List<CharacterItem>
    suspend fun getUrlCharacters(): List<CharacterItem>
}