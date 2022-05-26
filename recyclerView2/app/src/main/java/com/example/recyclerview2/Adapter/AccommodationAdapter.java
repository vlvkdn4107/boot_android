package com.example.recyclerview2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview2.R;
import com.example.recyclerview2.model.Accommodation;

import java.util.ArrayList;

public class AccommodationAdapter extends RecyclerView.Adapter<AccommodationAdapter.MyViewHorder>{

    ArrayList<Accommodation> list;
    Context context;

    public AccommodationAdapter(ArrayList<Accommodation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemlayout,parent,false);

        MyViewHorder myViewHorder = new MyViewHorder(view);
        return myViewHorder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHorder holder, int position) {
        Accommodation accommodation = list.get(position);
        holder.AcdName.setText(accommodation.getTitle());
        holder.where.setText(accommodation.getWhere());
        holder.subtext.setText(accommodation.getSubtitle());
        holder.price.setText(accommodation.getPrice());
        Glide.with(context).load(accommodation.getThumbnail())
                .transform(new CenterCrop(),new RoundedCorners(30)).into(holder.thumbnailView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //내부클래스
    public class MyViewHorder extends RecyclerView.ViewHolder{

        ImageView thumbnailView;
        TextView AcdName;
        TextView where;
        TextView subtext;
        TextView price;
//        Button button;

        public MyViewHorder(@NonNull View itemView) {
            super(itemView);
            thumbnailView =itemView.findViewById(R.id.thumbnailView);
            AcdName = itemView.findViewById(R.id.AcdName);
            where = itemView.findViewById(R.id.where);
            subtext = itemView.findViewById(R.id.subtext);
            price = itemView.findViewById(R.id.price);
//            button = itemView.findViewById(R.id.btn1);


        }
    }
}
