package com.example.lottogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button addBtn;
    private Button initBtn;
    private Button runBtn;
    private NumberPicker numberPicker;

    private ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private Set<Integer> pickerNumberSet = new HashSet<>();
    private boolean didRun = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListner();
        getRandomNumber();

    }
    private void initData(){
        numberTextViewList.add(findViewById(R.id.textView1));
        numberTextViewList.add(findViewById(R.id.textView2));
        numberTextViewList.add(findViewById(R.id.textView3));
        numberTextViewList.add(findViewById(R.id.textView4));
        numberTextViewList.add(findViewById(R.id.textView5));
        numberTextViewList.add(findViewById(R.id.textView6));

        addBtn = findViewById(R.id.addButton);
        initBtn = findViewById(R.id.initButton);
        runBtn = findViewById(R.id.runButton);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);
    }
    private void addEventListner(){
        runBtn.setOnClickListener(view ->{
            //랜덤 list(1~5)
            List<Integer> list = getRandomNumber();
            //set 사용자가 선택한 번호(1~5)
            list.addAll(pickerNumberSet);
            Collections.sort(list);

            didRun = true;
            //xml 출력
            for(int i = 0; i < list.size(); i++){
                numberTextViewList.get(i).setText(String.valueOf(list.get(i)));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                // 숫자 범위에 따라 원의 색 다르게 처리
                numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));

            }
        });
        addBtn.setOnClickListener(view ->{
            if(didRun){
                Toast.makeText(this, "초기화 후에 시도", Toast.LENGTH_SHORT).show();
                return;
            }
            //NumberPicker에 현재 값을 불러온다
            int selectedNumber = numberPicker.getValue();

            //번호는 5개 까지 선택 가능!
            if(pickerNumberSet.size() >= 5){
                Toast.makeText(this,"번호는 5개까지 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            // 똑같은 번호 선택시 예외 처리
            if(pickerNumberSet.contains(selectedNumber)){
                Toast.makeText(this, "이미 선택한 번호 입니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(view.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));


            pickerNumberSet.add(selectedNumber);


        });
        initBtn.setOnClickListener(view ->{
            didRun = false;
            pickerNumberSet.clear();
            for(TextView tv : numberTextViewList){
                tv.setVisibility(View.GONE);
            }
        });
    }
    private List<Integer> getRandomNumber(){
        ArrayList<Integer> list = new ArrayList<>();
        // 랜덤 번호를 1번부터 45번 까지 Set에 담기

        for(int i = 1; i < 46; i++){
            if(pickerNumberSet.contains(i)){
                // 번호 중복 안되도록 continue 처리
                continue;
            }
            list.add(i); // 1~45까지 값이 담긴다.
        }
        //shuffle - 랜덤배치 ,순서가 있는 list 계열만 들어갈 수 있다.
        Collections.shuffle(list);
        return list.subList(0, 6 - pickerNumberSet.size());
        //0 ~6 번째까지 잘라라
    }
    // 숫자 크기에 따라서 배경을 다르게 만듬
    private Drawable setTextViewBackground(int number){
        Drawable drawable = null;
        if(number < 11){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background3);
        }else if(number < 21){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background1);
        }else if(number < 31){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background4);
        }else if(number < 41){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background2);
        }else{
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background5);
        }
        return  drawable;
    }
}