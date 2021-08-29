package com.example.a3_2dz.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a3_2dz.data.db.daos.CharacterDao;
import com.example.a3_2dz.data.db.daos.EpisodeDao;
import com.example.a3_2dz.data.db.daos.LocationDao;
import com.example.a3_2dz.model.Character;
import com.example.a3_2dz.model.EpisodeModel;
import com.example.a3_2dz.model.LocationModel;

@Database(entities = {Character.class, EpisodeModel.class, LocationModel.class},version = 3)
abstract class APPDataBase extends  RoomDatabase {

    public abstract CharacterDao characterDao();
    public abstract EpisodeDao episodeDao();
    public abstract LocationDao locationDao();
}