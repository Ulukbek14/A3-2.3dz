package com.example.a3_2dz.data.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a3_2dz.model.EpisodeModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrayList<EpisodeModel> episodeModels);

    @Query("SELECT * FROM episodeModel")
    List<EpisodeModel> getAll();
}