package com.example.a3_2dz.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3_2dz.R;
import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.databinding.ItemCharacterBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private ItemCharacterBinding binding;
    private ArrayList<Character> list = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @NotNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding.getRoot());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void addList(ArrayList<Character> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {

        public CharacterViewHolder(@NotNull View itemView) {
            super(itemView);
            binding.getRoot().setOnClickListener(v -> {
                listener.onItemClick(getAdapterPosition());
            });
        }

        private void onBind(Character item) {
           binding.ivItemCharacter.setImageResource(R.drawable.ic_launcher_background);
           binding.tvItemCharacterName.setText(item.getName());
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}

