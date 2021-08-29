package com.example.a3_2dz.data.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a3_2dz.model.Character;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void  insertAll(ArrayList<Character> character);

    @Query("SELECT * FROM character")
    List<Character> getAll();
}