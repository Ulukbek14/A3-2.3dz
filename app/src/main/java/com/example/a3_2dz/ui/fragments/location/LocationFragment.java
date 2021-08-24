package com.example.a3_2dz.ui.fragments.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dz.databinding.FragmentLocationBinding;

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
        viewModel = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
        setupRequest();
        initialize();
    }

    private void setupRequest() {
        viewModel.fetchLocation().observe(getViewLifecycleOwner(), locationModelRickAndMortyResponse -> {
            locationAdapter.addList2(locationModelRickAndMortyResponse.getResults());
        });
    }


    private void initialize() {
        binding.rvLocation.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvLocation.setAdapter(locationAdapter);
    }
}