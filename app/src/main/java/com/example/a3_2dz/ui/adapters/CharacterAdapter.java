package com.example.a3_2dz.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3_2dz.R;
import com.example.a3_2dz.data.network.RetrofitClient;
import com.example.a3_2dz.interf.OnItemClickListener;
import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.databinding.ItemCharacterBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private OnItemClick listener;
    private List<Character> list = new ArrayList<>();
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(List<Character> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        ItemCharacterBinding binding;

        public CharacterViewHolder(ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(Character item) {
            Glide.with(binding.ivItemCharacter).load(item.getImage()).into(binding.ivItemCharacter);
            binding.tvItemCharacterName.setText(item.getName());
            binding.getRoot().setOnClickListener(v -> {
                listener.onItemClick(item.getId());

            });
        }
    }

    public interface OnItemClick {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClick listener) {
        this.listener = listener;
    }
}