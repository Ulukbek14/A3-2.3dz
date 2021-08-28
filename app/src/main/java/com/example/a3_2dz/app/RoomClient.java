package com.example.a3_2dz.app;

import android.content.Context;

import androidx.room.Room;

import com.example.a3_2dz.data.db.daos.CharacterDao;
import com.example.a3_2dz.data.db.daos.EpisodeDao;
import com.example.a3_2dz.data.db.daos.LocationDao;

public class RoomClient {

    public APPDataBase provideDatabase(Context context) {
        APPDataBase db = Room
                .databaseBuilder(context, APPDataBase.class, "rick-and-morty_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        return db;
    }

    public CharacterDao provideCharacterDao(APPDataBase appDataBase) {
        return appDataBase.characterDao();
    }
    public EpisodeDao provideEpisodeDao(APPDataBase appDataBase){
        return appDataBase.episodeDao();
    }
    public LocationDao provideLocationDao(APPDataBase appDataBase){
        return  appDataBase.locationDao();
    }
}