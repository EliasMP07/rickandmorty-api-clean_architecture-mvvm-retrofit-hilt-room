package com.devdroid.rickandmortyapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("results")val characters: List<Character>
)