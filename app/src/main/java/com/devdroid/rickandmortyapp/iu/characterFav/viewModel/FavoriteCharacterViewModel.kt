package com.devdroid.rickandmortyapp.iu.characterFav.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.usecase.getAllCharacterFavorites
import com.devdroid.rickandmortyapp.iu.utils.ResponseStatus
import com.devdroid.rickandmortyapp.iu.utils.makeCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteCharacterViewModel @Inject constructor(
    private val getAllCharacterFavorites: getAllCharacterFavorites
) : ViewModel(){

    private val _listCharacter = MutableLiveData<List<CharacterItem>?>()
    val listCharacter : LiveData<List<CharacterItem>?> = _listCharacter

    private val _stateList = MutableLiveData<ResponseStatus<List<CharacterItem>>>()
    val stateList: LiveData<ResponseStatus<List<CharacterItem>>> = _stateList

    fun getAllFavoriteCharacter(){
        viewModelScope.launch {
            _stateList.value = ResponseStatus.Loading()
            makeCall {
                getAllCharacterFavorites()
            }.let {
                if (it is ResponseStatus.Success)
                    _listCharacter.value = it.data
                _stateList.value = it
            }
        }
    }
}