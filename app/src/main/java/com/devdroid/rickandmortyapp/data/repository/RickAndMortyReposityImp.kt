package com.devdroid.rickandmortyapp.data.repository

import com.devdroid.rickandmortyapp.data.local.dao.CharacterDao
import com.devdroid.rickandmortyapp.data.local.entities.CharacterLocationaAndOrigin
import com.devdroid.rickandmortyapp.data.local.entities.toDatabase
import com.devdroid.rickandmortyapp.data.remote.api.RickAndMortyApiClient
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.model.toDomain
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyReposityImp @Inject constructor(
    private val api: RickAndMortyApiClient,
    private val dao: CharacterDao
) : RickAndMortyRepository{
    override suspend fun getCharacterOffline(): List<CharacterItem> {
        if (dao.countCharacter() == 0){
            val listCharactersAndLocation = mutableListOf<CharacterLocationaAndOrigin>()
            api.obtenerCharacter().body()?.characters?.forEach {
                listCharactersAndLocation.add(
                    CharacterLocationaAndOrigin(
                        it.toDatabase(),
                        it.location!!.toDatabase(),
                        it.origin!!.toDatabase()
                    )
                )
            }

            dao.insertCharactersLocationAndOrigin(listCharactersAndLocation)

        }



        //Obtiene todos los Characters

        val listCharacters = mutableListOf<CharacterItem>()

        dao.getAllCharacterAndLocation().forEach {
            val entity = it.character.toDomain()
            entity.origin = it.origin.toDomain()
            entity.location = it.location.toDomain()
            listCharacters.add(entity)
        }
        return listCharacters
    }

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

    override suspend fun getCharacterById(id: Int): CharacterItem {

        val characterLocationAndOrigin = dao.getCharacterById(id)

        return characterLocationAndOrigin.character.toDomain().apply {
            origin = characterLocationAndOrigin.origin.toDomain()
            location = characterLocationAndOrigin.location.toDomain()
        }

    }

    override suspend fun updateFavoriteCharacter(character: CharacterItem) {
        dao.updateFavoriteCharacter(character.toDatabase())
    }

    override suspend fun getAllFavoritesCharacter(): List<CharacterItem> {
        val listCharacters = mutableListOf<CharacterItem>()

        dao.getFavoritesCharacter().forEach {
            val entity = it.character.toDomain()
            entity.origin = it.origin.toDomain()
            entity.location = it.location.toDomain()
            listCharacters.add(entity)
        }
        return listCharacters
    }


}