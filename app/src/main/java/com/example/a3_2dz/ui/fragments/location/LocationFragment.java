package com.example.a3_2dz.ui.fragments.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dz.databinding.FragmentLocationBinding;
import com.example.a3_2dz.model.LocationModel;
import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.ui.adapters.LocationAdapter;

import org.jetbrains.annotations.NotNull;


public class LocationFragment extends Fragment {

    FragmentLocationBinding binding;
    LocationViewModel viewModel;
    LocationAdapter locationAdapter = new LocationAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRecycler();
        setupRequest();
    }

    private void setupRecycler() {
        binding.rvLocation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLocation.setAdapter(locationAdapter);
    }

    private void setupRequest() {
        viewModel.fetchLocation().observe(getViewLifecycleOwner(), new Observer<RickAndMortyResponse<LocationModel>>() {
            @Override
            public void onChanged(RickAndMortyResponse<LocationModel> locationModelRickAndMortyResponse) {
                locationAdapter.addList2(locationModelRickAndMortyResponse.getResults());
            }
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
    }
}