package com.example.weekendstudent.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.weekendstudent.Fragment.FragmentTwo;
import com.example.weekendstudent.OnsampleDataClicklistener;
import com.example.weekendstudent.R;
import com.example.weekendstudent.sampleData.Sample;

import java.util.ArrayList;

public class MarketAdapter extends  RecyclerView.Adapter<MarketAdapter.MyViewHorder>{

    ArrayList<Sample> samplelist;
    Context context;
    OnsampleDataClicklistener onsampleDataClicklistener;


    public MarketAdapter(ArrayList<Sample> samplelist, Context context) {
        this.samplelist = samplelist;
        this.context = context;

    }
    @NonNull
    @Override
    public MyViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycleitem,parent,false);
        return new MyViewHorder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHorder holder, int position) {
        Sample sample = samplelist.get(position);
        holder.titleView.setText(sample.getTitle());
        holder.subtitle.setText(sample.getSubtext());
        holder.price.setText(sample.getPrice());
        Glide.with(context)
                .load(sample.getImgURL())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.itemThumnail);


    }

    @Override
    public int getItemCount() {
        return samplelist.size();
    }


    // 내부클래스 (홀더)
    public class MyViewHorder extends RecyclerView.ViewHolder{

        ImageView itemThumnail;
        TextView titleView;
        TextView subtitle;
        TextView price;

        public MyViewHorder(@NonNull View itemView) {
            super(itemView);
            itemThumnail = itemView.findViewById(R.id.thumnailView);
            titleView = itemView.findViewById(R.id.fragtitleText);
            subtitle = itemView.findViewById(R.id.subtitle);
            price = itemView.findViewById(R.id.price);
        }
    }




}
