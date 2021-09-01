package com.example.a3_2dz.data.network;

import com.example.a3_2dz.data.network.apiservices.CharacterAPIService;
import com.example.a3_2dz.data.network.apiservices.EpisodeAPIService;
import com.example.a3_2dz.data.network.apiservices.LocationAPIService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    private HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private Retrofit provideRetrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public CharacterAPIService provideCharacterApiService() {
        return provideRetrofit.create(CharacterAPIService.class);
    }
    public EpisodeAPIService provideEpisodeApiService(){
        return provideRetrofit.create(EpisodeAPIService.class);
    }
    public LocationAPIService provideLocationApiService(){
        return provideRetrofit.create(LocationAPIService.class);
    }
}