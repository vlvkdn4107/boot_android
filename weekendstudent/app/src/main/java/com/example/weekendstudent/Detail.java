package com.example.weekendstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weekendstudent.sampleData.Sample;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent() != null){
            Sample sample = (Sample)getIntent().getSerializableExtra("obj");
        }
    }
}