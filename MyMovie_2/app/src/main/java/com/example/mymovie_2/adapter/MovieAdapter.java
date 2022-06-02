package com.example.mymovie_2.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovie_2.R;

public class MovieAdapter {


public static class MyViewHolder extends RecyclerView.ViewHolder{

    private View itemView;
    private ImageView imageView;
    private TextView titleTextView;
    private TextView yearTextView;
    private TextView ratingNum;
    private RatingBar ratingBar;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imageView = itemView.findViewById(R.id.imageView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
    }
}
}
