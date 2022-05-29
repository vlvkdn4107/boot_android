package com.example.weekendstudent.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.weekendstudent.Fragment.FragmentFive;
import com.example.weekendstudent.Fragment.FragmentFour;
import com.example.weekendstudent.Fragment.FragmentOne;
import com.example.weekendstudent.Fragment.FragmentThree;
import com.example.weekendstudent.Fragment.FragmentTwo;
import com.example.weekendstudent.MainActivity;

public class MyAdapter extends FragmentPagerAdapter {


    public MyAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentOne();
                break;
            case 1:
                fragment = new FragmentTwo();
                break;
            case 2:
                fragment = new FragmentThree();
                break;
            case 3:
                fragment = new FragmentFour();
                break;
            case 4:
                fragment = new FragmentFive();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return new MainActivity().getAdapterCount();
    }
}
