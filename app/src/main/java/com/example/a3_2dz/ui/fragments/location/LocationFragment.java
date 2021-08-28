package com.example.a3_2dz.ui.fragments.location;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

    private LocationAdapter locationAdapter = new LocationAdapter();
    private LocationViewModel viewModel;
    private FragmentLocationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
        initalize();
        isConnectInternet();
    }

    private void setupRequests() {
        viewModel.fetchLocations().observe(getViewLifecycleOwner(),locationRickAndMortyResponse -> {
            locationAdapter.addList(locationRickAndMortyResponse.getResults());
        });
    }

    private void isConnectInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            setupRequests();
        } else {
            locationAdapter.addList(viewModel.getLocations());
        }
    }

    private void initalize() {
        setupLocationRecycler();
    }

    private void setupLocationRecycler() {
        binding.rvLocation.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvLocation.setAdapter(locationAdapter);
    }
}