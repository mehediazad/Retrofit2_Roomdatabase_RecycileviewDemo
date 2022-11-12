package com.example.retrofit2_roomdatabase_recycileviewdemo.Network;

import com.example.retrofit2_roomdatabase_recycileviewdemo.Model.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    Call<List<Test>> getData();
}
