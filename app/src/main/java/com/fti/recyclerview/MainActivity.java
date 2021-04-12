package com.fti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMotor;
    private ArrayList<MotorcycleModel> listMotor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMotor = findViewById(R.id.rv_team_list);
        rvMotor.setHasFixedSize(true);
        listMotor.addAll(MotorcycleData.getListData());

        showRecyclerView();
    }

    public void showRecyclerView(){
        rvMotor.setLayoutManager(new LinearLayoutManager(this));
        MotorcycleAdapter motorcycleAdapter = new MotorcycleAdapter(this);
        motorcycleAdapter.setMotorcycleModels(listMotor);
        rvMotor.setAdapter(motorcycleAdapter);
    }
}