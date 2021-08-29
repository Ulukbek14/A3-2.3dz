package com.example.a3_2dz.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.model.RickAndMortyResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {

    int page;

    public MutableLiveData<RickAndMortyResponse<Character>> fetchCharacters(int page) {
        MutableLiveData<RickAndMortyResponse<Character>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters(page).enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Character>> call, Response<RickAndMortyResponse<Character>> response) {
                if (response.body() != null) {
                    App.characterDao.insertAll(response.body().getResults());
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Character>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    MutableLiveData<Character> dataId = new MutableLiveData<>();

    public MutableLiveData<Character> fetchData(int id) {
        App.characterApiService.fetCharactersId(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                dataId.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                dataId.setValue(null);
            }
        });
        return dataId;
    }

    public List<Character> getCharacters() {
        return App.characterDao.getAll();
    }
}