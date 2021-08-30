package com.example.a3_2dz.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.model.EpisodeModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeRepository {

    int page;
    public MutableLiveData<RickAndMortyResponse<EpisodeModel>> fetchEpisodes(int page){
        MutableLiveData<RickAndMortyResponse<EpisodeModel>> data = new MutableLiveData<>();
        App.episodeApiService.fetchEpisodes(page).enqueue(new Callback<RickAndMortyResponse<EpisodeModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<EpisodeModel>> call, Response<RickAndMortyResponse<EpisodeModel>> response) {
                if (response.body() !=null){
                    App.episodeDao.insertAll(response.body().getResults());
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<EpisodeModel>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
    public List<EpisodeModel> getEpisode() {
        return App.episodeDao.getAll();
    }
}