package com.example.retrofit2_roomdatabase_recycileviewdemo.Repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.example.retrofit2_roomdatabase_recycileviewdemo.Database.TestDao;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Database.TestDatabase;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Model.Test;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Network.Api;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Network.ApiCallingInstance;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRepository {

    private static TestDatabase testDatabase;
    private List<Test> getAllTests;
    private Application application;
    private Api apiClient;

    public TestRepository(Application application) {
        this.application = application;
        apiClient = ApiCallingInstance.getRetrofit().create(Api.class);
        testDatabase = TestDatabase.getInstance(application);
        getAllTests = testDatabase.testDao().getAllTests();
    }

   public List<Test> getGetAllTests() {
        return getAllTests;
   }

    public void requestTestDataFromServer(Context context) {
        Call<List<Test>> call = apiClient.getData();
        call.enqueue(new Callback<List<Test>>() {
            @Override
            public void onResponse(Call<List<Test>> call, Response<List<Test>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Size " + response.body().size(), Toast.LENGTH_SHORT).show();

                    // insert Room Database
                    testDatabase.testDao().insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Test>> call, Throwable t) {
                Toast.makeText(context, "something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
