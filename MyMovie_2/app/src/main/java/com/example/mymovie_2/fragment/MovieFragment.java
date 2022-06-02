package com.example.mymovie_2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymovie_2.R;
import com.example.mymovie_2.databinding.FragmentPage1Binding;

public class MovieFragment extends Fragment {
    private FragmentPage1Binding movieBinding;
    private static final String TAG = MovieFragment.class.getName();

    public MovieFragment() {}

    // TODO: Rename and change types and number of parameters
    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        movieBinding = FragmentPage1Binding.inflate(inflater,container,false);
        return  movieBinding.getRoot();
    }
}