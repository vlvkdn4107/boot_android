package com.example.mydiary2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;
    private AppCompatButton openBtn;
    private AppCompatButton changeBtn;

    private boolean changeMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inidData();
        addEventListener();
    }



    private void inidData() {
        openBtn = findViewById(R.id.openBtn);
        changeBtn = findViewById(R.id.changeBtn);
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker1.setMaxValue(9);
        numberPicker1.setMinValue(0);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker3 = findViewById(R.id.numberPicker3);
        numberPicker3.setMaxValue(9);
        numberPicker3.setMinValue(0);
    }
    private void addEventListener() {
        openBtn.setOnClickListener(event -> {
            if(changeMode){
                Toast.makeText(this, "기다려!", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            String passwordUser = "" + numberPicker1.getValue()
                                     + numberPicker2.getValue()
                                     + numberPicker3.getValue();
            if(passwordPreferences.getString("password","000").equals(passwordUser)){
                Intent intent =new Intent(this,Diary.class);
                startActivity(intent);
            }else{
                showErrorAlertDialog();
            }
        });
        changeBtn.setOnClickListener(event ->{

        });
    }
    private void showErrorAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못 되었습니다.")
                .setPositiveButton("닫기",(dialog, which) -> {

                });
        builder.show();
    }

}