package com.fti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvNameMotor,tvDesc, tvPrice;
    private ImageView ivCoverMotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNameMotor = findViewById(R.id.tvNameMotor);
        tvDesc = findViewById(R.id.tvDescMotor);
        ivCoverMotor = findViewById(R.id.ivCoverMotor);
        tvPrice = findViewById(R.id.tvPriceMotor);

        String sName = getIntent().getStringExtra("nameMotor");
        String sDesc = getIntent().getStringExtra("descMotor");
        String sPrice= "Rp. " + getIntent().getStringExtra("priceMotor");
        int iCover = getIntent().getIntExtra("imageMotor",0);

        Glide.with(this).load(iCover).into(ivCoverMotor);
        tvNameMotor.setText(sName);
        tvDesc.setText(sDesc);
        tvPrice.setText(sPrice);

    }
}