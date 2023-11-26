package com.devdroid.rickandmortyapp.di

import android.content.Context
import androidx.room.Room
import com.devdroid.rickandmortyapp.data.repository.RickAndMortyReposityImp
import com.devdroid.rickandmortyapp.data.local.RickAndMortyDatabase
import com.devdroid.rickandmortyapp.data.local.dao.CharacterDao
import com.devdroid.rickandmortyapp.data.remote.api.RickAndMortyApiClient
import com.devdroid.rickandmortyapp.data.utils.Constants
import com.devdroid.rickandmortyapp.domain.repository.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class)
object injectionModule {

    private const val DATABASE_NAME = "rickandmorty_db"


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
    fun provideRickAndMortyRepository(apiClient: RickAndMortyApiClient, dao: CharacterDao): RickAndMortyRepository {
        return RickAndMortyReposityImp(apiClient, dao)
    }

    /*
    Funciones que provee Room
     */

     @Singleton
     @Provides
     fun provideRoom(
         @ApplicationContext context: Context
     ): RickAndMortyDatabase{
         return Room.databaseBuilder(context, RickAndMortyDatabase::class.java, DATABASE_NAME).build()
     }

    @Singleton
    @Provides
    fun provideCharacterDao(db: RickAndMortyDatabase): CharacterDao{
        return db.characterDao()
    }

}