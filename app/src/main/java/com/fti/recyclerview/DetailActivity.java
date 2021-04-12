package com.fti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvTeam,tvDesc;
    private ImageView ivCoverTeam;
    private String sDesc,sCoach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTeam = findViewById(R.id.tvNamaTeam);
        tvDesc = findViewById(R.id.tvDesc);
        ivCoverTeam = findViewById(R.id.ivCoverTeam);

        String sTeam = getIntent().getStringExtra("nameMotor");
        int iCover = getIntent().getIntExtra("imageMotor",0);

        if (sTeam.equals("Real Madrid")){
            sDesc = "Real Madrid adalah sebuah tim yang sangat keren sekali sehingga dipuji dan disukai oleh banyak orang.\n\nBanyak orang yang ingin masuk sini namun sangat sulit sehingga kebanyakan dari mereka menyerah";
        }

        Glide.with(this).load(iCover).into(ivCoverTeam);
        tvTeam.setText(sTeam);
        tvDesc.setText(sDesc);

    }
}