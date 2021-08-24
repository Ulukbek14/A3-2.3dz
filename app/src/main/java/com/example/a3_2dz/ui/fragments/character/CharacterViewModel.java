package com.example.a3_2dz.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dz.data.network.apiservices.App;
import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.model.Character;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    public MutableLiveData<RickAndMortyResponse<Character>> fetchCharacters(){
        MutableLiveData<RickAndMortyResponse<Character>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Character>> call, Response<RickAndMortyResponse<Character>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Character>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }


    public MutableLiveData<Character> fetchId(int id){
        MutableLiveData<Character> dataId = new MutableLiveData<>();
        App.characterApiService.fetCharactersId(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, @NotNull Response<Character> response) {
                dataId.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                dataId.setValue(null);
            }
        });
        return dataId;
    }

}
