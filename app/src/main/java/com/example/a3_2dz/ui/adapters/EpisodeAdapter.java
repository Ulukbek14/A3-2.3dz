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
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private ItemEpisodeBinding binding;
    private List<EpisodeModel> list = new ArrayList<>();

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new  EpisodeViewHolder(binding.getRoot()) ;
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addList(List<EpisodeModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {

        private void onBind(EpisodeModel episodeModel){
            binding.itemEpisode.setText(episodeModel.getName());
            binding.itemEpisode2.setText(episodeModel.getAir_date());
            binding.itemEpisode3.setText(episodeModel.getCreated());
            binding.itemEpisode4.setText(episodeModel.getEpisode());
        }

        public EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}