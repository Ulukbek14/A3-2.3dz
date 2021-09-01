package com.example.a3_2dz.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dz.databinding.ItemLocationBinding;
import com.example.a3_2dz.model.LocationModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends ListAdapter<LocationModel, LocationAdapter.LocationViewHolder> {


    public static class LocationDiffUtil extends DiffUtil.ItemCallback<LocationModel> {

        @Override
        public boolean areItemsTheSame(@NonNull LocationModel oldItem, @NonNull LocationModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull LocationModel oldItem, @NonNull LocationModel newItem) {
            return oldItem == newItem;
        }
    }

    public LocationAdapter() {
        super(new LocationDiffUtil());
    }

    @NonNull
    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.LocationViewHolder holder, int position) {
        holder.onBind(getItem(position));
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