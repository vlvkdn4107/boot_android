package com.example.inflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = findViewById(R.id.ImageView1);
        ImageView imageView2 = findViewById(R.id.ImageView2);
        ImageView imageView3 = findViewById(R.id.ImageView3);
        ImageView imageView4 = findViewById(R.id.ImageView4);
        ImageView imageView5 = findViewById(R.id.ImageView5);
        ImageView imageView6 = findViewById(R.id.ImageView6);

        Glide.with(this).load(R.drawable.temp).circleCrop().into(imageView1);
        Glide.with(this).load("https://picsum.photos/200/300").circleCrop().into(imageView2);
        Glide.with(this).load(R.drawable.ic_android_black_24dp).circleCrop().into(imageView3);
        Glide.with(this).load("https://picsum.photos/id/237/200/300").circleCrop().into(imageView4);
        Glide.with(this).load("https://picsum.photos/200/300?grayscale").circleCrop().into(imageView5);
        Glide.with(this).load(R.drawable.temp2).circleCrop().into(imageView6);

    }
}