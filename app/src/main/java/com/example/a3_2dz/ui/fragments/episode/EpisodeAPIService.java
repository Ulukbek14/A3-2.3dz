package com.example.a3_2dz.ui.fragments.episode;

import com.example.a3_2dz.ui.fragments.episode.EpisodeModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeAPIService {

    @GET("api/episode")
    Call<RickAndMortyResponse<EpisodeModel>> fetchEpisode();
}
