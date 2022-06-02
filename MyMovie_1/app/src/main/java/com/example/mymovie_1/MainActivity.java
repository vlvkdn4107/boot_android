package com.example.mymovie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mymovie_1.databinding.ActivityMainBinding;
import com.example.mymovie_1.utills.FragmentType;


public class MainActivity extends AppCompatActivity {

    // 뷰 바인딩 생성 방법
    // 1. 안드로이드가 만들어준 객체 선언
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. 객체 초기화
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 3. 연결
        setContentView(binding.getRoot());
        replaceFargment(FragmentType.MOVIE);
        addBottomNavListener();
    }

    private void replaceFargment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.newInstance(); // MOVIE TAG
        } else {
            fragment = InfoFragment.newInstance(); // INFO TAG
        }
        //
        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    private void addBottomNavListener() {
        binding.bottomNav.setOnItemSelectedListener(event -> {
            switch (event.getItemId()) {
                case R.id.page1:
                    replaceFargment(FragmentType.MOVIE);
                    break;
                case R.id.page2:
                    replaceFargment(FragmentType.INFO);
                    break;
            }

            return true;
        });
    }
}