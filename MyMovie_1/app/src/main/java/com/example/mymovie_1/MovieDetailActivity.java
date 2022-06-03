
package com.example.mymovie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.mymovie_1.databinding.ActivityMovieDetailBinding;
import com.example.mymovie_1.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    // 디테일코드를 짤때 유형 2가지
    // 1. 데이터를 전달 받아서 화면을 꾸미는 방법
    // 2. 여기서 통신요청해서 화면을 구성하는 방법
    private Movie movie;
    public static final String PRAM_NAME_1 = "movie obj";

    // 바인딩 처리
    private ActivityMovieDetailBinding activityMovieDetailBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(activityMovieDetailBinding.getRoot());

        if(getIntent() != null){
            movie = (Movie)getIntent().getSerializableExtra(PRAM_NAME_1);
            initData();
            addEventListener();
        }
    }

    private void initData() {
        activityMovieDetailBinding.detailTitleTextView.setText(movie.getTitle());
        activityMovieDetailBinding.detailYearTextView.setText("제작년도 : "+movie.getYear() + "년");
        activityMovieDetailBinding.detailRunTimeTextView.setText("상영시간 : "+movie.getRuntime() + "분");
        Glide.with(this)
                .load(movie.getMediumCoverImage())
                .into(activityMovieDetailBinding.detialMoviesPoster);

        Glide.with(this)
                .load(movie.getBackgroundImage())
                .into(activityMovieDetailBinding.backgroundImgView);
    }
    private void addEventListener() {
    }
}