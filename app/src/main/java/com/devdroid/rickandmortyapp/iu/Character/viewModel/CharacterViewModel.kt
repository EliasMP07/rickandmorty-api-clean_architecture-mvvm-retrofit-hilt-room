package com.devdroid.rickandmortyapp.iu.Character.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.rickandmortyapp.data.local.dao.CharacterDao
import com.devdroid.rickandmortyapp.data.local.entities.toDatabase
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.domain.usecase.getListRickAndMortyUseCase
import com.devdroid.rickandmortyapp.iu.utils.ResponseStatus
import com.devdroid.rickandmortyapp.iu.utils.makeCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getListRickAndMortyUseCase: getListRickAndMortyUseCase,
    private val dao: CharacterDao
) : ViewModel(){

    private val _listCharacter = MutableLiveData<List<CharacterItem>?>()
    val listCharacter : LiveData<List<CharacterItem>?> = _listCharacter

    private val _stateList = MutableLiveData<ResponseStatus<List<CharacterItem>>>()
    val stateList: LiveData<ResponseStatus<List<CharacterItem>>> = _stateList

    fun onClickFavorite(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _listCharacter.value?.forEach {
                if (it.id == id){
                    it.favorite = !it.favorite
                    dao.updateFavoriteCharacter(it.toDatabase())
                }
            }
        }
    }
    fun getAllCharacter(){
        viewModelScope.launch {
            _stateList.value = ResponseStatus.Loading()
            makeCall {
                getListRickAndMortyUseCase()
            }.let {
                if (it is ResponseStatus.Success)
                    _listCharacter.value = it.data
                _stateList.value = it
            }
        }
    }

}