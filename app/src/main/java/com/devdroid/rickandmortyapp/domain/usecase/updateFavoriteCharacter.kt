package com.devdroid.rickandmortyapp.domain.usecase

import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class updateFavoriteCharacter @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(character: CharacterItem){
        repository.updateFavoriteCharacter(character)
    }
}