package com.example.weekendstudent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weekendstudent.Adapter.MarketAdapter;
import com.example.weekendstudent.Adapter.MyAdapter;
import com.example.weekendstudent.Fragment.FragmentTwo;
import com.example.weekendstudent.sampleData.Sample;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private int AdapterCount = 5;
    ViewPager viewPager;
    MyAdapter myAdapter;
    MarketAdapter marketAdapter;

    public int getAdapterCount() {
        return AdapterCount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();


    }
    private void initData(){
        viewPager = findViewById(R.id.pagerView);
        myAdapter = new MyAdapter(getSupportFragmentManager(),AdapterCount);
        viewPager.setAdapter(myAdapter);

    }
    private void addEventListener(){

    }



}

//        marketAdapter = new MarketAdapter(Sample.getSample(), this){
//        };
//        ArrayList<Sample> sampleList = Sample.getSample();
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(marketAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.hasFixedSize();