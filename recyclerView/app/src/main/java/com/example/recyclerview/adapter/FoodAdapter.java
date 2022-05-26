package com.example.recyclerview.adapter;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;
// 뷰 홀더 만들기

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyviewHorder>{

    // 멤버변수 선언
    ArrayList<Food> list;
    // 어느 뷰를 쓸건지 받을 놈
    Context context;
    // 콜백 이벤트 받기 위해 생성
    OnFoodItemClickListener onFoodItemClickListener;

    public FoodAdapter(ArrayList<Food> list, Context context,OnFoodItemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public MyviewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 내부클래스로 만든 ViewHorder 생성
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food,parent, false);

        return new MyviewHorder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHorder holder, int position) {
        //화면과 연결하는 부분
        //데이터 맵핑
        Log.d("TAG","position" + position);
        Food food = list.get(position);
        holder.titleTextView.setText(food.getTitle());
        holder.subTitleView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());
        Glide.with(context)
                .load(food.getThumbnail())
//                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        // 리싸이클러뷰가 반복적인 하나의 아이템들을 그릴껀데 몇개있는지 알려달라 (스크롤 처리하기 위해)
        return list.size();
    }

    // 1. 내부클래스 만들기 (RecyclerView.ViewHolder 를 상속받아 사용해야한다)
    public class MyviewHorder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView titleTextView;
        TextView subTitleView;
        TextView detailTextView;

        public MyviewHorder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleView = itemView.findViewById(R.id.subTitleTextview);
            detailTextView = itemView.findViewById(R.id.detailTextView);

            itemView.setOnClickListener(view ->{
                Toast.makeText(view.getContext(), "TEST" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            // 콜백 메서드 호출
                onFoodItemClickListener.onItemClicked(itemView, getLayoutPosition());
            });
        }
    }// end of inner class

}
