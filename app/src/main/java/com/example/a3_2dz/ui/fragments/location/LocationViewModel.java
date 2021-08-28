package com.example.a3_2dz.ui.fragments.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.data.repository.LocationRepository;
import com.example.a3_2dz.model.LocationModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends ViewModel {

    private final LocationRepository repository = new LocationRepository();

    MutableLiveData<RickAndMortyResponse<LocationModel>> fetchLocations() {
        return repository.fetchLocations();
    }
    List<LocationModel> getLocations(){
        return repository.getLocation();
    }
}