package com.devdroid.rickandmortyapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.devdroid.rickandmortyapp.data.local.entities.CharacterAndLocation
import com.devdroid.rickandmortyapp.data.local.entities.CharacterEntity
import com.devdroid.rickandmortyapp.data.local.entities.LocationEntity

@Dao
interface CharacterDao {

    @Query("SELECT Count(id) FROM character_table")
    suspend fun countCharacter(): Int

    @Query("SELECT * FROM character_table")
    suspend fun getAllCharacterAndLocation(): List<CharacterAndLocation>

    @Insert
    suspend fun insertCharacter(character: CharacterEntity)

    @Insert
    suspend fun insertLocation(location: LocationEntity)

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacter(characters : List<CharacterEntity>)
    */
    @Transaction
    suspend fun insertCharactersAndLocation(characters: List<CharacterAndLocation>){
        for (characterWithLocation in characters){
            insertCharacter(characterWithLocation.character)

            characterWithLocation.location.id = characterWithLocation.character.id!!
            insertLocation(characterWithLocation.location)
        }
    }

    @Transaction
    suspend fun insertCharacterAndLocation(character:CharacterEntity, location: LocationEntity){
        insertCharacter(character)
        location.id = character.id!!
        insertLocation(location)
    }

}