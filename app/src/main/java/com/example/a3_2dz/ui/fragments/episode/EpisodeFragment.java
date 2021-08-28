package com.example.a3_2dz.ui.fragments.episode;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dz.databinding.FragmentEpisodeBinding;
import com.example.a3_2dz.model.EpisodeModel;
import com.example.a3_2dz.ui.adapters.EpisodeAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EpisodeFragment extends Fragment {

    private FragmentEpisodeBinding binding;
    private EpisodeViewModel viewModel;
    private EpisodeAdapter episodeAdapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =
                new ViewModelProvider(requireActivity()).get(EpisodeViewModel.class);
        initialize();
        isConnectInternet();
    }

    private void setupRequests() {
        viewModel.fetchEpisodes().observe(getViewLifecycleOwner(), episodeRickAndMortyResponse -> {
            episodeAdapter.addList(episodeRickAndMortyResponse.getResults());
        });
    }

    private void isConnectInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            setupRequests();
        } else {
            episodeAdapter.addList(viewModel.getEpisodes());
        }
    }

    private void initialize() {
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        binding.rvEpisode.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvEpisode.setAdapter(episodeAdapter);
    }
}