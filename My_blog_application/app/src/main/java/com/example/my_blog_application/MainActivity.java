package com.example.my_blog_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String LIFE_CYCLE = "life_cycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 상속 객체에 onCreate 메서드 호출
        super.onCreate(savedInstanceState);
        // 화면을 이 xml파일로 그려준다, 즉 activity에 그려준다
        // 처음에 화면을 그리는 것은 단 한번만 그려준다.
        setContentView(R.layout.layout);

    }

}