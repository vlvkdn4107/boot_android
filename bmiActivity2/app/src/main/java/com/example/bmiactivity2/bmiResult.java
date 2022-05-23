package com.example.bmiactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class bmiResult extends AppCompatActivity {
    TextView bmiresult;
    TextView heightTextView;
    TextView weightTextView;

    String heightValue = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        bmiresult = findViewById(R.id.bmiresult);
        heightTextView = findViewById(R.id.height);
        weightTextView = findViewById(R.id.weight);

        if(getIntent() != null){
            int height = getIntent().getIntExtra("height",0);
            int weight = getIntent().getIntExtra("weight",0);
            double bmiValue = weight / Math.pow(height/100.0,2);
            Log.d("TAG", height + "");
            Log.d("TAG", weight + "");
            Log.d("TAG", bmiValue + "");

            bmiresult.setText("");
            heightTextView.setText("신장 : " + Integer.toString(height));
            weightTextView.setText("체중 : " +Integer.toString(weight));
            if(bmiValue < 18.5){
                bmiresult.setText("저체중입니다.");
            }else if(bmiValue < 23){
                bmiresult.setText("정상 체중입니다.");
            }else{
                bmiresult.setText("과체중 입니다.");
            }
        }
    }
}