package com.example.a3_2dz.data.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a3_2dz.model.LocationModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrayList<LocationModel> locationModels);

    @Query("SELECT * FROM locationmodel")
    List<LocationModel> getAll();
}