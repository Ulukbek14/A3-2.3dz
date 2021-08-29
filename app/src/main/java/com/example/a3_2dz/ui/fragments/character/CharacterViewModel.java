package com.example.a3_2dz.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.base.BaseViewModel;
import com.example.a3_2dz.data.repository.CharacterRepository;
import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.model.Character;

import java.util.List;

public class CharacterViewModel extends BaseViewModel {

    int page = 1;
    private final CharacterRepository repository = new CharacterRepository();


    MutableLiveData<RickAndMortyResponse<Character>> fetchCharacters() {
        return repository.fetchCharacters(page);
    }

    public MutableLiveData<Character> fetchData(int id) {
        return repository.fetchData(id);
    }

    public List<Character> getCharacters() {
        return repository.getCharacters();
    }
}