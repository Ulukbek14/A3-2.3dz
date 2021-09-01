package com.example.a3_2dz.ui.fragments.episode;

import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dz.base.BaseViewModel;
import com.example.a3_2dz.data.repository.EpisodeRepository;
import com.example.a3_2dz.model.EpisodeModel;
import com.example.a3_2dz.model.RickAndMortyResponse;

import java.util.List;

public class EpisodeViewModel extends BaseViewModel {

    public int page = 1;
    private final EpisodeRepository repository = new EpisodeRepository();

    MutableLiveData<RickAndMortyResponse<EpisodeModel>> fetchEpisodes() {
        return repository.fetchEpisodes(page);
    }

    public List<EpisodeModel> getEpisodes() {
        return repository.getEpisode();
    }
}