package com.devdroid.rickandmortyapp.di

import com.devdroid.rickandmortyapp.data.RickAndMortyReposityImp
import com.devdroid.rickandmortyapp.data.remote.api.RickAndMortyApiClient
import com.devdroid.rickandmortyapp.data.remote.model.CharacterResult
import com.devdroid.rickandmortyapp.data.utils.Constants
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class)
object injectionModule {


    //***Parte que inyecta Retrofit***

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideeRickAndMortyApi(retrofit: Retrofit): RickAndMortyApiClient {
        return retrofit.create(RickAndMortyApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideRickAndMortyRepository(apiClient: RickAndMortyApiClient): RickAndMortyRepository {
        return RickAndMortyReposityImp(apiClient)
    }

}