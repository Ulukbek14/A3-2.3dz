package com.example.a3_2dz.ui.fragments.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dz.data.network.apiservices.App;
import com.example.a3_2dz.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends ViewModel {

    MutableLiveData<RickAndMortyResponse<LocationModel>> fetchLocation(){
        MutableLiveData<RickAndMortyResponse<LocationModel>> data = new MutableLiveData<>();
        App.locationAPIService.fetchLocation().enqueue(new Callback<RickAndMortyResponse<LocationModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<LocationModel>> call, Response<RickAndMortyResponse<LocationModel>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<LocationModel>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }

}