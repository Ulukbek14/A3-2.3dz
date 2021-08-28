package com.example.a3_2dz.data.network.apiservices;

import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterAPIService {
    @GET("api/character")
    Call<RickAndMortyResponse<Character>> fetchCharacters();
    @GET("api/character/{id}")
    Call<Character> fetCharactersId(@Path("id") int id);
}