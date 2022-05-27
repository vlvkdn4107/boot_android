package com.example.taplayout_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;


/*
 * pager
 * -화면(종이를 넘기듯이 화면을 넘겨주는 역할)
 * 준비물
 * -Adapter
 * -TabLayout
 *   tap을 담당하는 역할
 *
 * 보통 같이 작성을 하지만 따로따로 만들어도 상관이 없다.
 *
 * 리스너
 * pager 와 TabLayout을 연결해주기 위해 필요하다
 *
 *
 * */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    static final int TAB_COUNT = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewPager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
        tabLayout.addTab(tabLayout.newTab().setText("THREEE"));

        //탭레이아웃 이벤트 처리 부분

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //1 탭에서 2번 탭으로 진행 했을때 (1번탭이 사라질때 뭔가 해야되는 일이 있다면??)
                // 새로운 탭이 선택 되었을떄 onTabSelected 에서 코드를 작성하면 된다.
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }
        });

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),TAB_COUNT);
        viewPager.setAdapter(myPagerAdapter);

        // 뷰 페이저와 탭 연동
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}

class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.TAB_COUNT;
    }
}