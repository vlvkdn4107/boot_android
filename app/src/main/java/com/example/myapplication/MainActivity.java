package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView ce;
    private TextView plus;
    private TextView result;


    String newValue = "0";
    String oldValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initData();
        addEventListner();
    }
    private void initData(){
        //        초기화
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        four = findViewById(R.id.four);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        ce = findViewById(R.id.ce);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);



        System.out.println("initData 메서드 호출");
    }
    private void addEventListner(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MYTAG", "one 이 눌러 졌어요");
                newValue = newValue + "1";
                result.setText(newValue);
//                if(result.getText().equals("0")){
//                    result.setText("");
//                }
//                result.setText(result.getText() + "1");
            }

        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MYTAG", "two 이 눌러 졌어요");
                newValue = newValue + "2";
                result.setText(newValue);
//                if(result.getText().equals("0")){
//                    result.setText("");
//                }
//                result.setText(result.getText() + "2");
            }
        });
        
        three.setOnClickListener(view ->{
            Log.d(TAG, "three 가 눌러 졌어요");
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "3");
            newValue = newValue + "3";
            result.setText(newValue);

        });
        four.setOnClickListener(view ->{
            Log.d(TAG, "four 가 눌러 졌어요");
            newValue = newValue + "4";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "4");
        });
        five.setOnClickListener(view ->{
            Log.d(TAG, "five 가 눌러 졌어요");
            newValue = newValue + "5";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "5");
        });
        six.setOnClickListener(view ->{
            Log.d(TAG, "six 가 눌러 졌어요");
            newValue = newValue + "6";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "6");
        });
        seven.setOnClickListener(view ->{
            Log.d(TAG, "seven 가 눌러 졌어요");
            newValue = newValue + "7";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "7");
        });
        eight.setOnClickListener(view ->{
            Log.d(TAG, "eight 가 눌러 졌어요");
            newValue = newValue + "8";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "8");
        });
        nine.setOnClickListener(view ->{
            Log.d(TAG, "nine 가 눌러 졌어요");
            newValue = newValue + "9";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "9");
        });
        zero.setOnClickListener(view ->{
            Log.d(TAG, "zero 가 눌러 졌어요");
            newValue = newValue + "0";
            result.setText(newValue);
//            if(result.getText().equals("0")){
//                result.setText("");
//            }
//            result.setText(result.getText() + "0");
        });
        ce.setOnClickListener(view ->{
            Log.d(TAG, "ce 가 눌러 졌어요");
            newValue = "0";
            oldValue = "0";
            result.setText("0");
        });
        plus.setOnClickListener(view ->{
            // 이미 구분은 가능함
            Log.d(TAG, "plus 가 눌러 졌어요");
            // newValue -> String 이라서 형변환 해야된다
            // 1. 1눌렀을때 newValue에 1이라는 값이 담겨 져있다
            // 2.
            int number1 = Integer.parseInt(newValue);
            int number2 = Integer.parseInt(oldValue);
            int sum = (number1 + number2);
            Log.d(TAG, "number1 :" + number1);
            Log.d(TAG, "number2 :" + number2);
            Log.d(TAG, "sum :" + sum);

            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
        });


        
    }

}

