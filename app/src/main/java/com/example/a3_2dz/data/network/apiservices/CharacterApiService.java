package com.example.a3_2dz.data.network.apiservices;

import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.ui.fragments.episode.EpisodeAPIService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//Spisal extends EpisodeAPIService
public interface CharacterApiService extends EpisodeAPIService {

    @GET("api/character")
    Call<RickAndMortyResponse<Character>> fetchCharacters();
    //Spical
    @GET("api/character/{id}")
    Call<Character> fetCharactersId(@Path("id") int id);
}
