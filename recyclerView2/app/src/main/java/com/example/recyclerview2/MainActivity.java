package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview2.model.Accommodation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Accommodation> sampleData
        //리싸이클러뷰를 사용하기 위해서
        // 1. Adapter 클래스를 직접 생성해야한다.
        // 2. LayoutManager 생성 해서 Adapter클래스와 연결해야 한다.

        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setAdapter(new Accommodation(Accommodation.));
    }
}