package com.smartherd.rickandmorty.extensions

import androidx.lifecycle.MutableLiveData
import com.smartherd.rickandmorty.model.Character

fun MutableLiveData<Character>.postCharacterValue(character: Character?) {
    this.postValue(character)
}
