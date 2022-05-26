package com.example.myaddview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Car> sampleData = Car.getCar();
        LinearLayout carContainer = findViewById(R.id.CarContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        sampleData.forEach(car -> {
            View view = inflater.inflate(R.layout.car,carContainer, false);

            ImageView carImageView = view.findViewById(R.id.imageView);
            TextView carNameTextview = view.findViewById(R.id.carnameTextview);
            TextView year = view.findViewById(R.id.year);
            TextView price = view.findViewById(R.id.price);
            TextView km = view.findViewById(R.id.km);

            carNameTextview.setText(car.carName);
            year.setText(car.year);
            price.setText(car.price);
            km.setText(car.km);
            Glide.with(this)
                    .load(car.imageUrl)
                    .centerCrop()
                    .into(carImageView);
            carContainer.addView(view);
        });
    }
}