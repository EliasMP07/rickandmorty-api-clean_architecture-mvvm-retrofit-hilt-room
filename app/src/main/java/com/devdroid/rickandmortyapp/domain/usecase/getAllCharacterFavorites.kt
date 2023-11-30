package com.devdroid.rickandmortyapp.domain.usecase

import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class getAllCharacterFavorites @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    suspend operator fun invoke(): List<CharacterItem>{
        return rickAndMortyRepository.getAllFavoritesCharacter()
    }
}