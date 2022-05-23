package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        if(getIntent() != null){
            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            // 체중 / 신장(m) * 신장(m)
            double bmiValue = weight / Math.pow(height / 100.0, 2);
            Log.d("TAG", bmiValue + "");
            String resultText = "";
            if(bmiValue < 18.5){
                resultText = "저체중입니다.";
            }else if(bmiValue < 23){
                resultText = "정상 체중입니다.";
            }

        }

    }
}