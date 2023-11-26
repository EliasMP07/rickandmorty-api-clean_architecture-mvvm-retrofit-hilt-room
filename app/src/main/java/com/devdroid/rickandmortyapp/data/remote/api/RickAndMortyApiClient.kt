package com.devdroid.rickandmortyapp.data.remote.api


import com.devdroid.rickandmortyapp.data.remote.model.CharacterResult

import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApiClient {

    @GET("character")
    suspend fun obtenerCharacter(): Response<CharacterResult>
}