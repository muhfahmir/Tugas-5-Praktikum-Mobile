package com.fti.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MotorcycleAdapter extends RecyclerView.Adapter<MotorcycleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MotorcycleModel> motorcycleModels;

    public MotorcycleAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<MotorcycleModel> getMotorcycleModels() {
        return motorcycleModels;
    }

    public void setMotorcycleModels(ArrayList<MotorcycleModel> motorcycleModels) {
        this.motorcycleModels = motorcycleModels;
    }

    @NonNull
    @Override
    public MotorcycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_motorcycle,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorcycleAdapter.ViewHolder viewHolder, int i){
        Glide.with(context).load(getMotorcycleModels().get(i).getImageMotor()).into(viewHolder.ivLogoTeam);
        viewHolder.tvNamaTeam.setText(getMotorcycleModels().get(i).getNameMotor());
        viewHolder.tvPriceMotor.setText(getMotorcycleModels().get(i).getPriceMotor());
        viewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(context, DetailActivity.class);
                moveIntent.putExtra("nameMotor", getMotorcycleModels().get(i).getNameMotor());
                moveIntent.putExtra("imageMotor", getMotorcycleModels().get(i).getImageMotor());
                moveIntent.putExtra("descMotor",getMotorcycleModels().get(i).getDescMotor());
                moveIntent.putExtra("priceMotor",getMotorcycleModels().get(i).getPriceMotor());
                context.startActivity(moveIntent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareSubject = getMotorcycleModels().get(i).getNameMotor();
                String shareBody = getMotorcycleModels().get(i).getNameMotor()+"\nHarga : Rp. "+ getMotorcycleModels().get(i).getPriceMotor()+"\n" +getMotorcycleModels().get(i).getDescMotor();
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(share, "Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getMotorcycleModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivLogoTeam;
        private TextView tvNamaTeam,tvPriceMotor;
        private Button btnDetail, btnShare;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivLogoTeam = itemView.findViewById(R.id.ivImageMotor);
            tvNamaTeam = itemView.findViewById(R.id.tvNameMotor);
            tvPriceMotor = itemView.findViewById(R.id.tvPriceMotor);
            btnDetail = itemView.findViewById(R.id.btnDetail);
            btnShare = itemView.findViewById(R.id.btnShare);
        }

    }
}
