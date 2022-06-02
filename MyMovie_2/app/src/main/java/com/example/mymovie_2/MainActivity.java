package com.example.mymovie_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mymovie_2.databinding.ActivityMainBinding;
import com.example.mymovie_2.fragment.InfoFragment;
import com.example.mymovie_2.fragment.MovieFragment;
import com.example.mymovie_2.utills.FragmentType;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(mainBinding.getRoot());
    replaceFragmen(FragmentType.MOVIE);
    addBottomNavListener();


    }



    private void replaceFragmen(FragmentType fragmentType) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =manager.beginTransaction();
        if(fragmentType == FragmentType.MOVIE){
             fragment = MovieFragment.newInstance();
        }else{
            fragment = InfoFragment.newInstance();
        }
        transaction.replace(mainBinding.mainContainer.getId(), fragment,fragmentType.toString());
        transaction.commit();
    }
    private void addBottomNavListener() {
        mainBinding.bottomNav.setOnItemSelectedListener(event -> {
            switch (event.getItemId()){
                case R.id.movieIcon:
                    replaceFragmen(FragmentType.MOVIE);
                    break;
                case R.id.infoIcon:
                    replaceFragmen(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }


}