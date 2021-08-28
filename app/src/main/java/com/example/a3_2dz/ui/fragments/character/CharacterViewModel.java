package com.example.a3_2dz.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dz.app.App;
import com.example.a3_2dz.data.repository.CharacterRepository;
import com.example.a3_2dz.model.RickAndMortyResponse;
import com.example.a3_2dz.model.Character;

import java.util.List;

public class CharacterViewModel extends ViewModel {

    private final CharacterRepository repository = new CharacterRepository();

    MutableLiveData<RickAndMortyResponse<Character>> fetchCharacters() {
        return repository.fetchCharacters();
    }

    public MutableLiveData<Character> fetchData(int id) {
        return repository.fetchData(id);
    }

    List<Character> getCharacters() {
        return repository.getCharacters();
    }
}