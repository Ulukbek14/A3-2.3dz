package com.example.a3_2dz.ui.fragments.character;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dz.ui.adapters.CharacterAdapter;
import com.example.a3_2dz.R;
import com.example.a3_2dz.databinding.FragmentCharacterBinding;

import org.jetbrains.annotations.NotNull;

import static androidx.core.content.ContextCompat.getSystemService;


public class CharacterFragment extends Fragment {

    private FragmentCharacterBinding binding;
    private CharacterAdapter characterAdapter = new CharacterAdapter();
    private CharacterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =
                new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        initialize();
        isConnectInternet();
    }

    private void isConnectInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            setupRequests();
        } else {
            characterAdapter.addList(viewModel.getCharacters());
        }
    }

    private void setupRequests() {
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characterRickAndMortyResponse ->
                characterAdapter.addList(characterRickAndMortyResponse.getResults()));
    }


    private void initialize() {
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        binding.recyclerCharacter.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerCharacter.setAdapter(characterAdapter);

        characterAdapter.setOnItemClickListener(position -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment().setPosition(position));
        });
    }
}