package com.example.retrofit2_roomdatabase_recycileviewdemo.Database;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.retrofit2_roomdatabase_recycileviewdemo.Model.Test;

@Database(entities = {Test.class}, version = 1,exportSchema = false)
public abstract class TestDatabase extends RoomDatabase {

    //Create database instance

    private static volatile TestDatabase INSTANCE;
    private static String DATABASE_NAME = "TestDatabase";

    public synchronized static TestDatabase getInstance( Context context) {
        if (INSTANCE == null){
            //Initialize Database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            ,TestDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    //Create Dao
    public abstract TestDao testDao();

}


