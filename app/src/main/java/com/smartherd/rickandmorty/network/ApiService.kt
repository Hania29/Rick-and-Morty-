package com.smartherd.rickandmorty.network

import com.smartherd.rickandmorty.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>
}