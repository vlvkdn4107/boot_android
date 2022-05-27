package com.example.tablayout_pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tablayout_pager.Adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private int TAB_COUNT = 3;
    private TabLayout tabLayout;
    private ViewPager pagerview;
    private MyPagerAdapter myPagerAdapter;
    private int position;

    public int getTAB_COUNT() {
        return TAB_COUNT;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

    }

    private void initData() {
        pagerview = findViewById(R.id.pagerview);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
        tabLayout.addTab(tabLayout.newTab().setText("THREE"));
    }

    private void addEventListener() {
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),TAB_COUNT);
        pagerview.setAdapter(myPagerAdapter);
        pagerview.addOnPageChangeListener
                (new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        // 탭 레이아웃 selected이벤트 처리
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                pagerview.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                position = tab.getPosition();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                position = tab.getPosition();
            }
        });

    }
}