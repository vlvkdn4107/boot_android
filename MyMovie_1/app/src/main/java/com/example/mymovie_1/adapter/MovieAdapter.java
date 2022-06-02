package com.example.mymovie_1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.mymovie_1.R;
import com.example.mymovie_1.models.Movie;

import java.util.ArrayList;
import java.util.List;

// 내부클래스 먼저 만들기
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHorder>{

    private List<Movie> list = new ArrayList<>();
    // 통신 배우기 전에는 생성자에서 데이터를 전달 받아서 화면을 구성했다면
    // 지금은 네이트워크 통신이기 때문에 화면을 그리는 시점 보다 더 늦게 데이터가 도달 할수 있다.

    public void addItemList(List<Movie> list){
        this.list = list;
        // 데이터가 변경되었으면 데이터를 바꿨다면 다시 그려주는놈
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);

        return new MyViewHorder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHorder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // inner static class
    // binding 결합 안된다! (직접 해야된다)  / view binding 은 단방향이다.
    // (data binding = 뷰결합인데 양방향이다.

    public static class MyViewHorder extends RecyclerView.ViewHolder{


        // itemView 에 선언한 데이터 타입을 선언하고 생성 시점에 R.id.?? 연결 해주면 된다.

        private View itemView;
        private ImageView posterImageView;
        private TextView titleTextView;
        private TextView ratingNum;
        private RatingBar ratingBar;

        public MyViewHorder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterImageView = itemView.findViewById(R.id.posterImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            ratingNum = itemView.findViewById(R.id.ratingNum);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
        public void setItem(Movie movie){
            // 여기 코드를 쓸때 개발자가 2가지로 나뉜다
            // 여기서 바로 셋팅하는 개발자
            titleTextView.setText(movie.getTitle());
            // int 타입이기 때문에 String.valueOf()
            ratingNum.setText(String.valueOf(movie.getRating()));
            // float 타입이기때문에 다운 캐스팅 (float)
            // 만약 9.312()이면 ---> Math.floor() 이렇게 쓰면된다
            ratingBar.setRating((float) movie.getRating());
            Glide.with(posterImageView.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterImageView);
            // view holder 안에서 하는 개발자
            // 뷰 홀더 안에 메서드를 만들어서
        }
    }// end of inner class

}


