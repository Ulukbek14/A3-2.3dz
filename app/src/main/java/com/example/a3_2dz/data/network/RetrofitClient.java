package com.example.a3_2dz.data.network;

import com.example.a3_2dz.data.network.apiservices.CharacterApiService;
import com.example.a3_2dz.ui.fragments.episode.EpisodeAPIService;
import com.example.a3_2dz.ui.fragments.location.LocationAPIService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .callTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    private HttpLoggingInterceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private final Retrofit provideRetrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public CharacterApiService provideCharacterApiService(){
        return provideRetrofit.create(CharacterApiService.class);
    }

    public EpisodeAPIService provideEpisodeApiService(){
        return provideRetrofit.create(EpisodeAPIService.class);
    }

    public LocationAPIService provideLocationApiService() {
        return provideRetrofit.create(LocationAPIService.class);
    }
}
