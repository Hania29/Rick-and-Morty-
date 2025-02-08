package com.smartherd.rickandmorty.network

import com.smartherd.rickandmorty.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): Response<com.smartherd.rickandmorty.model.Character> // ✅ Ensure correct return type

}