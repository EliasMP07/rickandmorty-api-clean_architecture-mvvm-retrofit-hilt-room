package com.devdroid.rickandmortyapp.data.remote.model

import com.google.gson.annotations.SerializedName


data class Character(
    @SerializedName("create")val created: String?,
    @SerializedName("gender")val gender: String?,
    @SerializedName("id")val id: Int,
    @SerializedName("image")val image: String?,
    @SerializedName("name")val name: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("origin") val origin: Origin?,
    @SerializedName("location") val location: Location?,
    @SerializedName("status") val status: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
)

