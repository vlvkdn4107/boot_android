package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Toast;

import com.example.myhttp.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 확장 프로그램 gerpper 설치
    // Gson 라이브러르 사용
    // build에 implementation 'com.google.code.gson:gson:2.8.6' 추가

    // TMI
    // 2.8.6  맨앞은 main 숫자가 바뀌면 완전히 많이 업데이트한거다
    // 두전째는 마이너 심각한 문제가있어서 업데이트한거다
    // 세번째는 그냥 짜잘한 업데이트했을때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 람다식으로 쓰레드 생성
        new Thread(() -> {
            httpGetText();
        }).start();
//        try {
//
//        } catch (NetworkOnMainThreadException e) {
//            Toast.makeText(this, "에러가 발생!!", Toast.LENGTH_SHORT).show();
//        }


        // http 연결 할때는 manifest에
        // uses-permission android:name="android.permission.INTERNET"/>
        //  <application> 에  android:usesCleartextTraffic="true" 추가 입력
        // 안드로이드 9.0부터 네트워크 통신 http를 막았음
        // https 이여야만 한다.
        // 하지만 usesCleartextTraffic = true 값을 주게 되면 http 통신이 가능 하다.
        // 안드로이드는 동작상 쓰레드는 화면을 그리는데에 집중을하고있다
        // 그래서 네트워크 연결할때는 쓰레드를 만들어서 써야한다.

    }

    private void httpGetText() {
        // https://jsonplaceholder.typicode.com/todos/1
        String urlString = "https://jsonplaceholder.typicode.com/todos";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 어떤 방식으로 요청 할껀지
            connection.setRequestMethod("GET");

            // 참고
//            connection.setRequestProperty("Content-Type", "application/json; charset = UTF-8");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 조건문이 200이라도 적어도되지만  HttpURLConnection.HTTP_OK 이렇게도 쓴다
                // 통신 성공하면 실행
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),
                        "UTF-8"));
                // 1. 한 라인( 한줄)
                //reader.ready();
//                String line = null;
//                StringBuffer sb = new StringBuffer();
//
//                // line에 reader에 한줄씩 읽고 null이 될때까지 반복해라
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//                Log.d("TAG", sb.toString());

                // Gson 사용 할려면 먼저 Dto만들어야한다
                // 하나의 문자열을 하나의 Object로 변환 하는 방법
//                Todo todo1 = new Gson().fromJson(reader, Todo.class);
//                Log.d("TAG", todo1.title);
                // 문자열 --> 배열 타입으로 변환 하는 방법
//                Todo[] todos = new Gson().fromJson(reader, Todo[].class);
//                Log.d("TAG", todos.toString());
                // 문자열 --> ArrayList 타입으로 변환 하는 방법
                // ArrayList 타입으로 변환하는 방법
                // 1.
                Type todoListTpye = new TypeToken<ArrayList<Todo>>(){}.getType();
                // 2.
                ArrayList<Todo> todoList = new Gson().fromJson(reader,todoListTpye);
                for(Todo t : todoList){
                    Log.d("TAG",  "userId : " + t.userId);
                    Log.d("TAG", "title : " + t.title);
                }


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}