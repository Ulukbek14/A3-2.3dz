package com.example.a3_2dz.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dz.ui.adapters.CharacterAdapter;
import com.example.a3_2dz.R;
import com.example.a3_2dz.databinding.FragmentCharacterBinding;

import org.jetbrains.annotations.NotNull;


public class CharacterFragment extends Fragment {

    private CharacterViewModel viewModel;
    private FragmentCharacterBinding binding;
    private CharacterAdapter characterAdapter = new CharacterAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRequest();
    }


    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        binding.recyclerCharacter.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerCharacter.setAdapter(characterAdapter);

//        characterAdapter.setOnClickListener(position -> {
//            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
//                    .navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment().(position);
//            );
//        });
    }

    private void setupRequest() {
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characters ->  {
            characterAdapter.addList(characters.getResults());
        });
    }
}