package com.example.bottom_nav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottom_nav.utills.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        addBottomNavigationListner();
        replaceFragment(FragmentType.HOME);
    }
    // 플래그먼트 교체하는 메서드
    private void replaceFragment(FragmentType type){
        Fragment fragment = new Fragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(type == FragmentType.HOME){
            fragment = new FragmentHome();
        }else if(type == FragmentType.HEAD){
            fragment = new FragmentHead();
        }else if(type == FragmentType.CHAT){
            fragment = new FragmentChat();
        }
        transaction.replace(R.id.fragmentContainer,fragment);
        transaction.commit();
    }


    private void addBottomNavigationListner(){
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.page_home:
                    Log.d("TAG", "home");
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.page_headset:
                    Log.d("TAG", "headset");
                    replaceFragment(FragmentType.HEAD);
                    break;
                case R.id.page_chat:
                    Log.d("TAG", "chat");
                    replaceFragment(FragmentType.CHAT);
                    break;
            }
            return true;
        });
    }
}