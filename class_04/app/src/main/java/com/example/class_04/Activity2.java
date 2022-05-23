package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    private Button btn1;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView = findViewById(R.id.nameTextView);
        //Activity1 로 부터 값을 받는 방법
        //값이 없다면 기본 값을 0으로 셋팅한다(null포인트를 방지)
        // 불필요한 연산 줄이기위해 방어적 코드 짜기
        if(getIntent() != null){
            String getDate = getIntent().getStringExtra(Activity1.KEY_NAME);
            textView.setText(getDate);

        }

    }


}