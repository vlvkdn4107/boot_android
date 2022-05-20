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
    private TextView equal;
    private TextView multi;
    private TextView minus;
    private TextView division;

    private TextView result1;
    private TextView c_Result;

    String newValue = "";
    String oldValue = "0";

    String calculation = "";

    String cr_Value = "";


    int number1 = 0;
    int number2 = 0;
    int result_value = 0;



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
        minus = findViewById(R.id.minus);
        division = findViewById(R.id.division);



        System.out.println("initData 메서드 호출");
    }
    private void addEventListner(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result1.getText().equals("0")){
                    result1.setText("1");
                    newValue =result1.getText().toString();
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
                    newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
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
                newValue =result1.getText().toString();
            }else{
                oldValue = result1.getText().toString();
                newValue = oldValue + "0";
                result1.setText(newValue);
            }
            if(c_Result.getText().equals("0")){

            }else if(number2 != 0){
                cr_Value = cr_Value + "0";
                c_Result.setText(cr_Value);
            }
        });
        ce.setOnClickListener(view ->{
            Log.d(TAG, "ce 가 눌러 졌어요");
            newValue = "0";
            oldValue = "0";
            result_value = 0;
            result1.setText("0");
            c_Result.setText("");
            cr_Value = "";
            Log.d("MYTAG", "newValue : " + newValue);
            Log.d("MYTAG", "oldValue : " + oldValue);
//            c_Result.setText("");
        });
        plus.setOnClickListener(view ->{

            number1 = Integer.parseInt(newValue);
            calculation = "+";
            result1.setText("");
            if(result_value != 0){
                cr_Value = "";
                cr_Value = oldValue + "+";
                c_Result.setText(oldValue + "+");


            }else if(result_value == 0){

                cr_Value = cr_Value + "+";
                c_Result.setText(cr_Value);
            }
        });

        multi.setOnClickListener(v -> {
            number1 = Integer.parseInt(newValue);
            calculation = "*";
            result1.setText("");
            if(result_value != 0){
                cr_Value = "";
                cr_Value = oldValue + "*";
                c_Result.setText(oldValue + "×");


            }else if(result_value == 0){

                cr_Value = cr_Value + "*";
                c_Result.setText(cr_Value);
            }
//            switch (calculation){
//                case "=" :
//                    c_Result.setText(oldValue + "x");
//                    break;
//                case "*" :
//                    cr_Value = cr_Value + "×";
//                    c_Result.setText(cr_Value);
//                    break;
//            }


        });
        minus.setOnClickListener(v -> {
            number1 = Integer.parseInt(newValue);
            calculation = "-";
            result1.setText("");
            if(result_value != 0){
                cr_Value = "";
                cr_Value = oldValue + "-";
                c_Result.setText(oldValue + "-");


            }else if(result_value == 0){

                cr_Value = cr_Value + "-";
                c_Result.setText(cr_Value);
            }

//            cr_Value = cr_Value + "-";
//            c_Result.setText(cr_Value);
        });
        division.setOnClickListener(v -> {

            calculation = "/";
            result1.setText("");


            cr_Value = cr_Value + "/";
            c_Result.setText(cr_Value);
        });


        equal.setOnClickListener(v -> {
            switch (calculation){
                case "+":
                    oldValue = result1.getText().toString();
                    newValue = result1.getText().toString();
                    number2 = Integer.parseInt(oldValue);
                    if(result_value == 0){
                        result_value = number1 + number2;
                        oldValue = String.valueOf(result_value);
                        result1.setText(oldValue);
                        c_Result.setText(cr_Value + " =");

                    }else if(result_value != 0){
                        result_value = result_value + number2;
                        oldValue = String.valueOf(result_value);
                        result1.setText(oldValue);
                        c_Result.setText(cr_Value + " =");
                    }
                    break;
                case "*":
                    oldValue = result1.getText().toString();
                    newValue = result1.getText().toString();
                    number2 = Integer.parseInt(oldValue);
                    if(result_value == 0){
                        result_value = number1 * number2;
                        oldValue = String.valueOf(result_value);
                        result1.setText(oldValue);
                        c_Result.setText(cr_Value + " =");

                    }else if(result_value != 0){
                        result_value = result_value * number2;
                        oldValue = String.valueOf(result_value);
                        result1.setText(oldValue);
                        c_Result.setText(cr_Value + " =");
                    }
                    break;
                case "-":
                    oldValue = result1.getText().toString();
                    newValue = result1.getText().toString();
                    number2 = Integer.parseInt(oldValue);
                    if(result_value == 0){
                        result_value = number1 - number2;
                        oldValue = String.valueOf(result_value);
                        result1.setText(oldValue);
                        c_Result.setText(cr_Value + " =");

                    }else if(result_value != 0){
                        result_value = result_value - number2;
                        oldValue = String.valueOf(result_value);
                        result1.setText(oldValue);
                        c_Result.setText(cr_Value + " =");
                    }
                    break;
                case "/":
                    break;
            }


        });
        
    }

}

