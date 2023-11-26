package com.devdroid.rickandmortyapp.domain.usecase

import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class getListRickAndMortyUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(): List<CharacterItem>{
        return repository.getCharacterOffline()
    }
}