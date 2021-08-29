package com.example.a3_2dz.app;

import android.app.Application;

import com.example.a3_2dz.data.db.daos.CharacterDao;
import com.example.a3_2dz.data.db.daos.EpisodeDao;
import com.example.a3_2dz.data.db.daos.LocationDao;
import com.example.a3_2dz.data.network.RetrofitClient;
import com.example.a3_2dz.data.network.apiservices.CharacterAPIService;
import com.example.a3_2dz.data.network.apiservices.EpisodeAPIService;
import com.example.a3_2dz.data.network.apiservices.LocationAPIService;

public class App extends Application {

    public static CharacterAPIService characterApiService;
    public static EpisodeAPIService episodeApiService;
    public static LocationAPIService locationApiService;
    public static CharacterDao characterDao;
    public static EpisodeDao episodeDao;
    public static LocationDao locationDao;
    public RetrofitClient retrofitClient = new RetrofitClient();


    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = retrofitClient.provideCharacterApiService();
        episodeApiService = retrofitClient.provideEpisodeApiService();
        locationApiService = retrofitClient.provideLocationApiService();
        RoomClient roomClient = new RoomClient();
        characterDao = roomClient.provideCharacterDao(roomClient.provideDatabase(this));
        episodeDao = roomClient.provideEpisodeDao(roomClient.provideDatabase(this));
        locationDao = roomClient.provideLocationDao(roomClient.provideDatabase(this));
    }
}