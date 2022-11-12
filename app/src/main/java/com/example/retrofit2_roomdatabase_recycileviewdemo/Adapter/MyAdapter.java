package com.example.retrofit2_roomdatabase_recycileviewdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit2_roomdatabase_recycileviewdemo.Database.TestDatabase;
import com.example.retrofit2_roomdatabase_recycileviewdemo.Model.Test;
import com.example.retrofit2_roomdatabase_recycileviewdemo.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Test> testList;

    public MyAdapter(Context context, List<Test> testList) {
        this.context = context;
        this.testList = testList;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_view_userId;
        TextView text_view_id;
        TextView text_view_title;
        TextView text_view_body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_view_userId = itemView.findViewById(R.id.text_view_userId);
            text_view_id = itemView.findViewById(R.id.text_view_id);
            text_view_title = itemView.findViewById(R.id.text_view_title);
            text_view_body = itemView.findViewById(R.id.text_view_body);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Test test = testList.get(position);

        holder.text_view_userId.setText(String.valueOf("userId : "+test.getUserId()));
        holder.text_view_id.setText(String.valueOf("id : "+test.getId()));
        holder.text_view_title.setText("title : "+test.getTitle());
        holder.text_view_body.setText("body : "+test.getBody());

    }
    @Override
    public int getItemCount() {
        return testList.size();
    }
    
}
