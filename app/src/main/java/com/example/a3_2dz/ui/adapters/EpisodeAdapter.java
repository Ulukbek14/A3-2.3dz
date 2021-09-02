package com.example.a3_2dz.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dz.databinding.ItemEpisodeBinding;
import com.example.a3_2dz.model.EpisodeModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends ListAdapter<EpisodeModel, EpisodeAdapter.EpisodeViewHolder> {

    public static class EpisodeDiffUtil extends DiffUtil.ItemCallback<EpisodeModel> {

        @Override
        public boolean areItemsTheSame(@NonNull EpisodeModel oldItem, @NonNull EpisodeModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull EpisodeModel oldItem, @NonNull EpisodeModel newItem) {
            return oldItem == newItem;
        }
    }

    public EpisodeAdapter() {
        super(new EpisodeDiffUtil());
    }

    @NonNull
    @Override
    public EpisodeAdapter.EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeViewHolder(ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.EpisodeViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    class EpisodeViewHolder extends RecyclerView.ViewHolder {
        ItemEpisodeBinding binding;

        public EpisodeViewHolder(ItemEpisodeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(EpisodeModel item) {
            binding.itemEpisode.setText(item.getName());
            binding.itemEpisode2.setText(item.getAir_date());
            binding.itemEpisode3.setText(item.getCreated());
            binding.itemEpisode4.setText(item.getEpisode());
        }
    }
}