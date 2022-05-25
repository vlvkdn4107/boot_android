package com.example.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = findViewById(R.id.imgview1);
        Glide.with(this)
                .load(R.drawable.temp)
                .circleCrop()
                .into(imageView1);
//        유명한건 피카소,Glide 이 2가지가있는데 기능은 Glide가 좀 더 많다
//        Glide.with(this)
//                .load("https://picsum.photos/seed/picsum/200/300")
//                .circleCrop()
//                .into(imageView1);
        //프로젝트에 있는 이미지 들을 라운드처리하는 라이브러리를 사용해서
        //circleCrop 처리 한다면 사용이 안된다.



    }
}