package com.example.a3_2dz.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dz.databinding.ItemLocationBinding;
import com.example.a3_2dz.model.LocationModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<LocationModel> list = new ArrayList<>();

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(List<LocationModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {
        ItemLocationBinding binding;

        public LocationViewHolder(@NonNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(LocationModel locationModel) {
            binding.itemLocation.setText(locationModel.getName());
            binding.itemLocation2.setText(locationModel.getType());
            binding.itemLocation3.setText(locationModel.getDimension());
            binding.itemLocation4.setText(locationModel.getCreated());
        }
    }
}