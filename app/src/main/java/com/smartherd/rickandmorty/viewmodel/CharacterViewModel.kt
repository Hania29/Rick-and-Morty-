package com.smartherd.rickandmorty.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartherd.rickandmorty.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()
    val characters = repository.characters

    fun fetchCharacters() {
        viewModelScope.launch {
            repository.fetchCharacters()
        }
    }
}