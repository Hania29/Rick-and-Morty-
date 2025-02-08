package com.smartherd.rickandmorty.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smartherd.rickandmorty.extensions.postCharacterValue
import com.smartherd.rickandmorty.model.Character
import com.smartherd.rickandmorty.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterDetailRepository {

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> get() = _character

    suspend fun fetchCharacterById(characterId: Int) {
        withContext(Dispatchers.IO) {

            val response = RetrofitClient.apiService.getCharacterById(characterId)
            if (response.isSuccessful) {
                _character.postValue(response.body())
            }
        }
    }
}

