package com.example.myhttp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.myhttp2.model.TodoDto;
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
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.textview);
        addEventListener();
    }

    private void httpGetTest(){
        String str_Url = "https://jsonplaceholder.typicode.com/posts";
        try {
            URL url = new URL(str_Url);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream(),
                                "UTF-8"));

                // ArrayList
                Type todoListtype =new TypeToken<ArrayList<TodoDto>>(){}.getType();
                ArrayList<TodoDto> todoDtoList = new Gson().fromJson(reader,todoListtype);
                for(TodoDto todolist : todoDtoList){
                    Log.d("TAG", "userId : " +todolist.userId);
                    Log.d("TAG", "userId : " +todolist.id);
                    Log.d("TAG","title : " + todolist.title);
                    Log.d("TAG","body : " +todolist.body);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void httpGetTitle(){
        String str_Url = "https://jsonplaceholder.typicode.com/posts";
        try {
            URL url = new URL(str_Url);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream(),
                                "UTF-8"));

                // ArrayList
                Type todoListtype =new TypeToken<ArrayList<TodoDto>>(){}.getType();
                ArrayList<TodoDto> todoDtoList = new Gson().fromJson(reader,todoListtype);
                for(TodoDto todolist : todoDtoList){
                    Log.d("TAG","title : " + todolist.title);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addEventListener(){
        button.setOnClickListener(v -> {
            new Thread(() ->{
                httpGetTitle();
            }).start();
        });
    }
}