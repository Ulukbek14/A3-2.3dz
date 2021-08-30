package com.example.a3_2dz.ui.fragments.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.base.BaseViewModel;
import com.example.a3_2dz.data.repository.LocationRepository;
import com.example.a3_2dz.model.LocationModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends BaseViewModel {

    public int page = 1;
    private final LocationRepository repository = new LocationRepository();

    MutableLiveData<RickAndMortyResponse<LocationModel>> fetchLocations() {
        return repository.fetchLocations(page);
    }

    public List<LocationModel> getLocations() {
        return repository.getLocation();
    }
}