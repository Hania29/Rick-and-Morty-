package com.smartherd.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartherd.rickandmorty.repository.CharacterDetailRepository
import kotlinx.coroutines.launch

class CharacterDetailViewModel : ViewModel() {

    private val repository = CharacterDetailRepository()
    val character = repository.character

    fun fetchCharacterDetails(characterId: Int) {
        viewModelScope.launch {
            repository.fetchCharacterById(characterId)
        }
    }
}
