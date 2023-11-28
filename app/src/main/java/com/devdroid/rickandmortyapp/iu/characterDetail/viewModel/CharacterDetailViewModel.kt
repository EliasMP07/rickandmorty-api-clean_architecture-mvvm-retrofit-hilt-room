package com.devdroid.rickandmortyapp.iu.characterDetail.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.usecase.getCharacterById
import com.devdroid.rickandmortyapp.iu.utils.ResponseStatus
import com.devdroid.rickandmortyapp.iu.utils.makeCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterById: getCharacterById
) : ViewModel() {




    private val _listCharacter = MutableLiveData<CharacterItem?>()
    val listCharacter : LiveData<CharacterItem?> = _listCharacter

    private val _state = MutableLiveData<ResponseStatus<CharacterItem>>()
    val state: LiveData<ResponseStatus<CharacterItem>> = _state

    fun getCharacter(id: Int){
        viewModelScope.launch {
            _state.value = ResponseStatus.Loading()

            makeCall {
                getCharacterById(id)
            }.let {
                if (it is ResponseStatus.Success)
                    _listCharacter.value = it.data
                _state.value = it
            }

        }
    }

}