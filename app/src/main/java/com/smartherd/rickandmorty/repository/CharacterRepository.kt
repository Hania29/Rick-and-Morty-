package com.smartherd.rickandmorty.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smartherd.rickandmorty.model.Character
import com.smartherd.rickandmorty.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    suspend fun fetchCharacters() {
        withContext(Dispatchers.IO) {
            val response = RetrofitClient.apiService.getCharacters()
            if (response.isSuccessful) {
                _characters.postValue(response.body()?.results)
            }
        }
    }
}