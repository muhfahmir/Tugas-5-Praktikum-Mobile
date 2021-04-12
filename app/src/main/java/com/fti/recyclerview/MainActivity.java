package com.fti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTeam;
    private ArrayList<MotorcycleModel> listTeam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.rv_team_list);
        rvTeam.setHasFixedSize(true);
        listTeam.addAll(MotorcycleData.getListData());

        showRecyclerView();
    }

    public void showRecyclerView(){
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        MotorcycleAdapter motorcycleAdapter = new MotorcycleAdapter(this);
        motorcycleAdapter.setMotorcycleModels(listTeam);
        rvTeam.setAdapter(motorcycleAdapter);
    }
}