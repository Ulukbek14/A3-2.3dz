package com.example.a3_2dz.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dz.databinding.ItemEpisodeBinding;
import com.example.a3_2dz.model.EpisodeModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {

    ItemEpisodeBinding binding;
    ArrayList<EpisodeModel> list = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public EpisodeAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EpisodeAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addList(ArrayList<EpisodeModel> episodeModels){
        this.list = episodeModels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private void onBind(EpisodeModel episodeModel){
            binding.itemEpisode.setText(episodeModel.getName());
            binding.itemEpisode2.setText(episodeModel.getAir_date());
            binding.itemEpisode3.setText(episodeModel.getEpisode());
            binding.itemEpisode4.setText(episodeModel.getCreated());
        }

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
