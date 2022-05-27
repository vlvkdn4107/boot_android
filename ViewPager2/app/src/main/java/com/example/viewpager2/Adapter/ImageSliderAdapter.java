package com.example.viewpager2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpager2.R;

import java.util.ArrayList;

// 뷰 홀더 생성
public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHorder> {
    private Context context;
    private ArrayList<String> sliderImage;

    public ImageSliderAdapter(Context context, ArrayList<String> sliderImage) {
        this.context = context;
        this.sliderImage = sliderImage;
    }

    @NonNull
    @Override
    public ViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_image_slider,parent,false);
        return new ViewHorder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHorder holder, int position) {
        // 난중에 할  http://image.jpg 를 여기에 넣는다
        holder.bindSliderImage(sliderImage.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderImage.size();
    }

    public class ViewHorder extends RecyclerView.ViewHolder {
        // 이미지뷰 생성
        private ImageView imageView;

        public ViewHorder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageslider);
        }

        public void bindSliderImage(String imageURL) {
            Glide.with(context)
                    .load(imageURL)
                    .centerCrop()
                    .into(imageView);
        }
    }// end of inner class
}
