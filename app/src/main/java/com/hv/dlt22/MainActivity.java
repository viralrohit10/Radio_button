package com.hv.dlt22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Context context;
    private List<Club> clubs;
    private Object Context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(clubs, (android.content.Context) Context);

        initializeData();
        initializeAdapter();

    }

    private void initializeData(){

        clubs = new ArrayList<Club>();
        clubs.add(new Club("Subtitle1", "Title1"));
        clubs.add(new Club("Subtitle2", "Title2"));
        clubs.add(new Club("Subtitle3", "Title3"));
        clubs.add(new Club("Subtitle4", "Title4"));
        clubs.add(new Club("Subtitle5", "Title5"));




        }

    @SuppressLint("ResourceType")
    private void initializeAdapter(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(clubs,this);
        recyclerView.setAdapter(adapter);

    }
}

class Club {
    String name;
    String title;

    Club(String name, String title) {
        this.name = name;
        this.title = title;
    }
}


