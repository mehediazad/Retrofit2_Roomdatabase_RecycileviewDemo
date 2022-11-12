package com.example.retrofit2_roomdatabase_recycileviewdemo.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.retrofit2_roomdatabase_recycileviewdemo.Model.Test;

import java.util.List;

@Dao
public interface TestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Test> testList);

    @Query("SELECT * FROM test")
   List<Test> getAllTests();

    @Query("DELETE FROM Test")
    void deleteAll();
}