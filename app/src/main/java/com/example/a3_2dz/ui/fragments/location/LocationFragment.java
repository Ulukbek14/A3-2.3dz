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
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dz.base.BaseFragment;
import com.example.a3_2dz.databinding.FragmentLocationBinding;
import com.example.a3_2dz.model.LocationModel;
import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.ui.adapters.LocationAdapter;

import org.jetbrains.annotations.NotNull;

public class LocationFragment extends BaseFragment<LocationViewModel, FragmentLocationBinding> {

    private LocationAdapter locationAdapter = new LocationAdapter();
    private LocationViewModel viewModel;
    private FragmentLocationBinding binding;
    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;
    public LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        super.initialize();
        setupLocationRecycler();
        viewModel = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
    }

    private void setupLocationRecycler() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.rvLocation.setLayoutManager(linearLayoutManager);
        binding.rvLocation.setAdapter(locationAdapter);
    }

    @Override
    protected void setUpRequests() {
        super.setUpRequests();
        if (!connectInternet()) {
            locationAdapter.submitList(viewModel.getLocations());
        }
        binding.rvLocation.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        viewModel.page++;
                        connectInternet();
                    }
                }
            }
        });
    }

    private boolean connectInternet() {
        if (isConnectInternet()) {
            viewModel.fetchLocations().observe(getViewLifecycleOwner(), locationRickAndMortyResponse -> {
                locationAdapter.submitList(locationRickAndMortyResponse.getResults());
            });
            return true;
        } else {
            return false;
        }
    }
}