package com.example.a3_2dz.data.network.apiservices;

import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.model.LocationModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationAPIService {
    @GET("api/location")
    Call<RickAndMortyResponse<LocationModel>> fetchLocations();
}