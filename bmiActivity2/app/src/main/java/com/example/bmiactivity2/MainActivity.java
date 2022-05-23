package com.example.bmiactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
//    Material에서 사용한 view가 TextInputLayout임
    TextInputLayout heightEt;
    TextInputLayout weightEt;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//       layout에서 설정한 id값으로 가져오기
        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
//
            Editable weightEditable= weightEt.getEditText().getText();
            Editable heightEditable= heightEt.getEditText().getText();

            if(heightEditable.length() < 1 || weightEditable.length() < 1){
                Toast.makeText(this, "빈 값이 있습니다", Toast.LENGTH_SHORT).show();
                return;
            }
                int height = Integer.parseInt(heightEditable.toString());
                int weight = Integer.parseInt(weightEditable.toString());
                Intent intent = new Intent(this, bmiResult.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                startActivity(intent);

        });
    }
}