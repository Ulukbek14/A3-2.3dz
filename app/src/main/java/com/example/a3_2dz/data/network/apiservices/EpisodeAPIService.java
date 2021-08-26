package com.example.a3_2dz.data.network.apiservices;

import com.example.a3_2dz.model.EpisodeModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeAPIService {

    @GET("api/episode")
    Call<RickAndMortyResponse<EpisodeModel>> fetchEpisode();
}
