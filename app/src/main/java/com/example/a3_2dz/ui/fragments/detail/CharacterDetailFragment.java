package com.example.a3_2dz.ui.fragments.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a3_2dz.base.BaseFragment;
import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.ui.fragments.character.CharacterViewModel;
import com.example.a3_2dz.databinding.FragmentCharacterDetailBinding;

import org.jetbrains.annotations.NotNull;

public class CharacterDetailFragment extends BaseFragment<CharacterViewModel, FragmentCharacterDetailBinding> {

    private FragmentCharacterDetailBinding binding;
    private CharacterViewModel viewModel;
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupArgs();
    }

    private void setupArgs() {
        id = CharacterDetailFragmentArgs.fromBundle(getArguments()).getPosition();
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }

    @Override
    protected void setUpRequests() {
        super.setUpRequests();
        viewModel.fetchData(id).observe(getViewLifecycleOwner(), character -> {
            Glide.with(binding.ivCharacterDetailFragment)
                    .load(character.getImage())
                    .into(binding.ivCharacterDetailFragment);
            binding.tvCharacterNameDetailFragment.setText(character.getName());
            binding.tvCharacterGenderDetailFragment.setText(character.getStatus());
        });
    }
}