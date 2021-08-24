package com.example.a3_2dz.ui.fragments.location;

import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.ui.fragments.location.LocationModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationAPIService {

    @GET("api/location")
    Call<RickAndMortyResponse<LocationModel>> fetchLocation();
}
