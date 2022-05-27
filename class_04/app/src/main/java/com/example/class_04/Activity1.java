package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "TAG";
    public static final String KEY_NAME = "key Name";

    private Button okBtn;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        initDate();
        addEventListner();
    }
    private void initDate(){
        nameEditText = findViewById(R.id.nameEditText);
        okBtn = findViewById(R.id.okBtn);
    }
    private void addEventListner(){
        okBtn.setOnClickListener(view ->{
            //1. 현재 nameEditText 뷰 컴포넌트에 값을 가져온다(방어적 코드)
            //2. 화면 전환 로직(인텐트 사용)
            String name = nameEditText.getText().toString();
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra(KEY_NAME, name);
            startActivity(intent);
        });
    }
}