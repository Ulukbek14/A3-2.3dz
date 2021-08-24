package com.example.a3_2dz.data.network.apiservices;

import android.app.Application;

import com.example.a3_2dz.data.network.RetrofitClient;
import com.example.a3_2dz.ui.fragments.episode.EpisodeAPIService;
import com.example.a3_2dz.ui.fragments.location.LocationAPIService;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static EpisodeAPIService episodeAPIService;
    public static LocationAPIService locationAPIService;

    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = new RetrofitClient().provideCharacterApiService();
        episodeAPIService = new RetrofitClient().provideEpisodeApiService();
        locationAPIService = new RetrofitClient().provideLocationApiService();
    }
}
