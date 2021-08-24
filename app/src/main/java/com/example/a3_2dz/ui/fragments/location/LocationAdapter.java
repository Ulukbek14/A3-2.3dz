package com.example.a3_2dz.ui.fragments.location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dz.databinding.ItemLocationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHodler> {

    ItemLocationBinding binding;
    ArrayList<LocationModel> list = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public LocationAdapter.ViewHodler onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHodler(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LocationAdapter.ViewHodler holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList2(ArrayList<LocationModel> locationModels){
        list = locationModels;
        notifyDataSetChanged();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private void onBind(LocationModel locationModel) {
            binding.itemLocation.setText(locationModel.getName());
            binding.itemLocation2.setText(locationModel.getType());
//            binding.itemLocation3.setText(locationModel.getDimension());
//            binding.itemLocation4.setText(locationModel.getResidents());
//            binding.itemLocation5.setText(locationModel.getUrl());
//            binding.itemLocation6.setText(locationModel.getCreated());
        }
        public ViewHodler(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
