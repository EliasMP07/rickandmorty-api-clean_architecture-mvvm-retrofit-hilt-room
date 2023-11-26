package com.devdroid.rickandmortyapp.data

import com.devdroid.rickandmortyapp.data.remote.api.RickAndMortyApiClient
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.model.toDomain
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyReposityImp @Inject constructor(
    private val api: RickAndMortyApiClient
) : RickAndMortyRepository{

    //Este se utitli
    override suspend fun getUrlCharacters(): List<CharacterItem> {
        val response = api.obtenerCharacter()
        return if(response.isSuccessful){
            response.body()?.characters?.map {
                it.toDomain()
            }?: emptyList()
        }else{
            throw Exception(response.errorBody()?.string())
        }
    }


}