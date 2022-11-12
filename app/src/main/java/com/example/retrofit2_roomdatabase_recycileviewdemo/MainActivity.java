package com.example.retrofit2_roomdatabase_recycileviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit2_roomdatabase_recycileviewdemo.Adapter.MyAdapter;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Database.TestDatabase;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Model.Test;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Network.Api;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Network.ApiCallingInstance;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Repository.TestRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Test> testList;
    private MyAdapter myAdapter;
    private TestRepository testRepository;
    private TestDatabase testDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        testList = new ArrayList<>();
        testDatabase = TestDatabase.getInstance(MainActivity.this);
        testRepository = new TestRepository(getApplication());

        testList = testDatabase.testDao().getAllTests();
        setAdapter();

        testRepository.requestTestDataFromServer(this);


    }


    private void setAdapter() {
        MyAdapter myAdapter = new MyAdapter(this, testList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }

}