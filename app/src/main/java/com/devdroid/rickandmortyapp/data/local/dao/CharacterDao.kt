package com.devdroid.rickandmortyapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.devdroid.rickandmortyapp.data.local.entities.CharacterLocationaAndOrigin
import com.devdroid.rickandmortyapp.data.local.entities.CharacterEntity
import com.devdroid.rickandmortyapp.data.local.entities.LocationEntity
import com.devdroid.rickandmortyapp.data.local.entities.OriginEntity

@Dao
interface CharacterDao {

    @Query("SELECT Count(id) FROM character_table")
    suspend fun countCharacter(): Int

    @Query("SELECT * FROM character_table")
    suspend fun getAllCharacterAndLocation(): List<CharacterLocationaAndOrigin>

    @Insert
    suspend fun insertCharacter(character: CharacterEntity)

    @Insert
    suspend fun insertLocation(location: LocationEntity)

    @Insert
    suspend fun insertOrigin(originEntity: OriginEntity)

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacter(characters : List<CharacterEntity>)
    */
    @Transaction
    suspend fun insertCharactersLocationAndOrigin(characters: List<CharacterLocationaAndOrigin>){
        for (characterLocationAndOrigin in characters){
            insertCharacter(characterLocationAndOrigin.character)

            characterLocationAndOrigin.location.id = characterLocationAndOrigin.character.id!!
            characterLocationAndOrigin.origin.id = characterLocationAndOrigin.character.id!!
            insertOrigin(characterLocationAndOrigin.origin)
            insertLocation(characterLocationAndOrigin.location)
        }
    }

    @Transaction
    suspend fun insertCharacterLocationAndOrigin(character:CharacterEntity, location: LocationEntity, origin: OriginEntity){
        insertCharacter(character)
        location.id = character.id!!
        insertLocation(location)
        origin.id = character.id!!
        insertOrigin(origin)
    }

}