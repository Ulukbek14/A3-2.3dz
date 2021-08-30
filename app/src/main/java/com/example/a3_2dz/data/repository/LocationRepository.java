package com.example.a3_2dz.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.model.LocationModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationRepository {

    int page;
    public MutableLiveData<RickAndMortyResponse<LocationModel>> fetchLocations( int page){
        MutableLiveData<RickAndMortyResponse<LocationModel>> data = new MutableLiveData<>();
        App.locationApiService.fetchLocations(page).enqueue(new Callback<RickAndMortyResponse<LocationModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<LocationModel>> call, Response<RickAndMortyResponse<LocationModel>> response) {
                if (response.body() != null) {
                    App.locationDao.insertAll(response.body().getResults());
                    data.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<RickAndMortyResponse<LocationModel>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
    public List<LocationModel> getLocation() {
        return App.locationDao.getAll();
    }
}