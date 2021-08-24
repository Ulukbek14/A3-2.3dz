package com.example.a3_2dz.ui.fragments.episode;

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

import org.jetbrains.annotations.NotNull;

public class EpisodeFragment extends Fragment {

    FragmentEpisodeBinding binding;
    EpisodeViewModel viewModel;
    EpisodeAdapter episodeAdapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(EpisodeViewModel.class);
        setupRequest();
        initialize();
    }


    private void setupRequest() {
        viewModel.fetchEpisode().observe(getViewLifecycleOwner(), episodeModelRickAndMortyResponse -> {
            episodeAdapter.addList(episodeModelRickAndMortyResponse.getResults());
        });
    }

    private void initialize() {
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        binding.rvEpisode.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvEpisode.setAdapter(episodeAdapter);
    }
}