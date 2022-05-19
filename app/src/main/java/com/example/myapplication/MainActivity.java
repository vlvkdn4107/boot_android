package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private static final String EQ = "EQ";
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
    private TextView result1;
    private TextView c_Result;

    private TextView equal;
    private TextView multi;

    String calculation = "";
    String newValue = "";
    String oldValue = "0";
    String cr_Value = "";


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
        result1 = findViewById(R.id.result1);
        c_Result = findViewById(R.id.c_Result);
        equal = findViewById(R.id.equal);
        multi = findViewById(R.id.multi);



        System.out.println("initData 메서드 호출");
    }
    private void addEventListner(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(result1.getText().equals("0")){
                    result1.setText("1");
                }else{
                    oldValue = result1.getText().toString();
                    newValue = oldValue + "1";
                    result1.setText(newValue);
                    Log.d("MYTAG", "!!!!!" + oldValue);
                    Log.d("MYTAG", "@@@@@@" + newValue);
                }
                if(c_Result.getText().equals("0")){
                    c_Result.setText("1");
                }else{

                    cr_Value = cr_Value + "1";
                    c_Result.setText(cr_Value);
                }

            }

        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result1.getText().equals("0")){
                    result1.setText("2");
                }else{
                    oldValue = result1.getText().toString();
                    newValue = oldValue + "2";
                    result1.setText(newValue);
                    Log.d("MYTAG", "!!!!!" + oldValue);
                    Log.d("MYTAG", "@@@@@@" + newValue);
                }
                if(c_Result.getText().equals("0")){
                    c_Result.setText("2");
                }else{

                    cr_Value = cr_Value + "2";
                    c_Result.setText(cr_Value);
                }
            }
        });
        
        three.setOnClickListener(view ->{
            Log.d(TAG, "three 가 눌러 졌어요");
            if(result1.getText().equals("0")){
                result1.setText("3");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "3";
                result1.setText(newValue);
                Log.d("MYTAG", "!!!!!" + oldValue);
                Log.d("MYTAG", "@@@@@@" + newValue);

            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("3");
            }else{

                cr_Value = cr_Value + "3";
                c_Result.setText(cr_Value);
            }
        });
        four.setOnClickListener(view ->{
            Log.d(TAG, "four 가 눌러 졌어요");
            if(result1.getText().equals("0")){
                result1.setText("4");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "4";
                result1.setText(newValue);
                Log.d("MYTAG", "!!!!!" + oldValue);
                Log.d("MYTAG", "@@@@@@" + newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("4");
            }else{

                cr_Value = cr_Value + "4";
                c_Result.setText(cr_Value);
            }
        });
        five.setOnClickListener(view ->{
            if(result1.getText().equals("0")){
                result1.setText("5");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "5";
                result1.setText(newValue);
                Log.d("MYTAG", "!!!!!" + oldValue);
                Log.d("MYTAG", "@@@@@@" + newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("5");
            }else{

                cr_Value = cr_Value + "5";
                c_Result.setText(cr_Value);
            }
        });
        six.setOnClickListener(view ->{
            if(result1.getText().equals("0")){
                result1.setText("6");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "6";
                result1.setText(newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("6");
            }else{

                cr_Value = cr_Value + "6";
                c_Result.setText(cr_Value);
            }
        });
        seven.setOnClickListener(view ->{
            if(result1.getText().equals("0")){
                result1.setText("7");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "7";
                result1.setText(newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("7");
            }else{

                cr_Value = cr_Value + "7";
                c_Result.setText(cr_Value);
            }
        });
        eight.setOnClickListener(view ->{
            if(result1.getText().equals("0")){
                result1.setText("8");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "8";
                result1.setText(newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("8");
            }else{

                cr_Value = cr_Value + "8";
                c_Result.setText(cr_Value);
            }
        });
        nine.setOnClickListener(view ->{
            if(result1.getText().equals("0")){
                result1.setText("9");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "9";
                result1.setText(newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("9");
            }else{

                cr_Value = cr_Value + "9";
                c_Result.setText(cr_Value);
            }
        });
        zero.setOnClickListener(view ->{
            if(result1.getText().equals("0")){
                result1.setText("0");
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "0";
                result1.setText(newValue);
            }
            if(c_Result.getText().equals("0")){
                c_Result.setText("0");
            }else{

                cr_Value = cr_Value + "0";
                c_Result.setText(cr_Value);
            }
        });
        ce.setOnClickListener(view ->{
            Log.d(TAG, "ce 가 눌러 졌어요");
            newValue = "0";
            oldValue = "0";
            result1.setText("0");
            c_Result.setText("");
            cr_Value = "";
            Log.d("MYTAG", "newValue : " + newValue);
            Log.d("MYTAG", "oldValue : " + oldValue);
//            c_Result.setText("");
        });
        plus.setOnClickListener(view ->{
            calculation = "+";
            result1.setText("");


            cr_Value = cr_Value + "+";
            c_Result.setText(cr_Value);





        });

        multi.setOnClickListener(v -> {

            calculation = "x";
            result1.setText("");


            cr_Value = cr_Value + "x";
            c_Result.setText(cr_Value);
        });

        equal.setOnClickListener(v -> {
            // newValue -> String 이라서 형변환 해야된다
            // 1. 1눌렀을때 newValue에 1이라는 값이 담겨 져있다
            // 2.

            switch (calculation){
                case "+":
                    Log.d("EQ", "eqNew : " + newValue);
                    Log.d("EQ", "eqOld : " + oldValue);
                    Log.d("EQ", "=====================================");
                    oldValue = result1.getText().toString();
                    int number1 = Integer.parseInt(newValue);
                    int number2 = Integer.parseInt(oldValue);
                    int sum = (number1 + number2);
                    oldValue = String.valueOf(sum);
                    result1.setText(oldValue);
                    c_Result.setText(cr_Value + " =");
                    newValue="0";
                    oldValue="0";
                    cr_Value="0";
                    Log.d("EQ", "number1 : " + number1);
                    Log.d("EQ", "number2 : " + number2);
                    Log.d("EQ", "=====================================");
//                    calculation = "";
                    break;
                case "x":
                    oldValue = result1.getText().toString();
                    int multi1 = Integer.parseInt(newValue);
                    int multi2 = Integer.parseInt(oldValue);
                    int multi_multi = (multi1 * multi2);
                    oldValue = String.valueOf(multi_multi);
                    result1.setText(oldValue);
                    c_Result.setText(cr_Value + " =");
                    newValue="0";
                    oldValue="0";
                    cr_Value="0";
                    break;
            }


        });
        
    }

}

