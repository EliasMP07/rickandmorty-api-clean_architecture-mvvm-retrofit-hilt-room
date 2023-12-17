package com.devdroid.rickandmortyapp.data.repository

import com.devdroid.rickandmortyapp.data.local.dao.CharacterDao
import com.devdroid.rickandmortyapp.data.local.entities.CharacterLocationaAndOrigin
import com.devdroid.rickandmortyapp.data.local.entities.toDatabase
import com.devdroid.rickandmortyapp.data.remote.api.RickAndMortyApiClient
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.model.LocationItem
import com.devdroid.rickandmortyapp.domain.model.OriginItem
import com.devdroid.rickandmortyapp.domain.model.toDomain
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyReposityImp @Inject constructor(
    private val api: RickAndMortyApiClient,
    private val dao: CharacterDao
) : RickAndMortyRepository{
    override suspend fun getCharacterOffline(): List<CharacterItem>{
        if (dao.countCharacter() == 0){
            api.obtenerCharacter().body()?.characters?.map {
                CharacterLocationaAndOrigin(
                    it.toDatabase(),
                    it.location!!.toDatabase(),
                    it.origin!!.toDatabase()
                )
            }?.let {
                listCharacterLocationAndOrigin ->
                dao.insertCharactersLocationAndOrigin(listCharacterLocationAndOrigin)
            }
        }

        return dao.getAllCharacterAndLocation().map {
            it.character.toDomain().apply {
                origin = it.origin.toDomain()
                location = it.location.toDomain()
            }
        }
    }


    override suspend fun getUrlCharacters(): List<CharacterItem>  = api.obtenerCharacter().takeIf{response -> response.isSuccessful}?.let{ it.body()?.characters?.map { it.toDomain() }?: emptyList() }?: throw Exception("Error al obtener los datos")


    override suspend fun getCharacterById(id: Int): CharacterItem = dao.getCharacterById(id).character.toDomain().apply {
        origin = dao.getCharacterById(id).origin.toDomain()
        location = dao.getCharacterById(id).location.toDomain()
    }


    override suspend fun getAllFavoritesCharacter(): List<CharacterItem> = dao.getFavoritesCharacter().map {
        it.character.toDomain().apply {
            origin = it.origin.toDomain()
            location = it.location.toDomain()
        }
    }


}