package com.example.myretrofit3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myretrofit3.Service.JPHService;
import com.example.myretrofit3.models.reqeust.ReqPostDto;
import com.example.myretrofit3.models.response.ResponsePostDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private JPHService service;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

    }
    private void initData(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        // service 초기화
        service = JPHService.retrofit.create(JPHService.class);
    }
    private void addEventListener(){
        btn1.setOnClickListener(view -> {
            service.post(10).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        // response.body() 자동 파싱 Json --> object 변환 처리
                        ResponsePostDto dto = response.body();
                        Log.d(TAG,dto + "");
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });
        });
        btn2.setOnClickListener(view -> {
            service.postList().enqueue(new Callback<List<ResponsePostDto>>() {
                @Override
                public void onResponse(Call<List<ResponsePostDto>> call, Response<List<ResponsePostDto>> response) {
                    Log.d(TAG,response.code() + "");
                    // List 파싱
                    ArrayList<ResponsePostDto> list = (ArrayList<ResponsePostDto>) response.body();
                    Log.d(TAG,list.toString());
                }

                @Override
                public void onFailure(Call<List<ResponsePostDto>> call, Throwable t) {

                }
            });
        });
        btn3.setOnClickListener(view -> {
            // userId 쪽에 로그인 (userId --> 쉐어드프리퍼런스에 저장해서 꺼내쓴다) (SQL Lite에 저장할수도있다)
            // 메모리에저장하고싶으면 멤버변수로 저장하면된다.
            ReqPostDto reqPostDto = new ReqPostDto("회의","DB설계회의",10);
            service.createPost(reqPostDto).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
                        Log.d(TAG,response.body().toString());
                    }else{
                        Toast.makeText(MainActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {
                    Log.d(TAG,t.toString());
                }
            });
        });
        btn4.setOnClickListener(view -> {
            ReqPostDto reqPostDto = new ReqPostDto("회의변경","spring회의",10);
            service.updatePost(10,reqPostDto).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "수정 성공", Toast.LENGTH_SHORT).show();
                        Log.d(TAG,response.body().toString());
                    }else{
                        Toast.makeText(MainActivity.this, "수정 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });
        });
        btn5.setOnClickListener(view -> {
            service.deletePost(1).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "삭제 성공", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        });

    }
}