package com.example.myglide;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //6개 이미지에 (인물 사진) 그리기
        ImageView imageView1 = findViewById(R.id.gImageView1);
        ImageView imageView2 = findViewById(R.id.gImageView2);
        ImageView imageView3 = findViewById(R.id.gImageView3);
        ImageView imageView4 = findViewById(R.id.gImageView4);
        ImageView imageView5 = findViewById(R.id.gImageView5);
        ImageView imageView6 = findViewById(R.id.gImageView6);

        Glide.with(this).load(R.drawable.temp).circleCrop().into(imageView1);
        Glide.with(this).load("https://picsum.photos/200/300").circleCrop().into(imageView2);
        Glide.with(this).load(R.drawable.ic_android_black_24dp).circleCrop().into(imageView3);
        Glide.with(this).load("https://picsum.photos/id/237/200/300").circleCrop().into(imageView4);
        Glide.with(this).load("https://picsum.photos/200/300?grayscale").circleCrop().into(imageView5);
        Glide.with(this).load(R.drawable.temp2).circleCrop().into(imageView6);




    }
}