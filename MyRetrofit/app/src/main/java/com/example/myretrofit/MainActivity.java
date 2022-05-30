package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretrofit.repository.models.RetrofitService;
import com.example.myretrofit.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


// 모델 분리
// 비즈니스 로직을 처리하는 부분을 분리 했음.
public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    RetrofitService service;
    TextView textView;
//    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.temp);
//        textView1 = findViewById(R.id.title1);
        // Retrofit : 실무에서 사용하는 라이브러리
        // build 에 def retrofit_version = "2.9.0"
        //dependencies {
        //    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
        //    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

        // Retrofit 객체 초기화
        // 빌더 패턴으로 설계 되어있다.
        // 내가 필요한거만 매개변수로 가져와서 사용할수있다.
        //baseUrl 사용시 반드시 마지막에 .com/ 을 해줘야한다.
        // addConverterFactory  Gson을 한방에 해주는 놈
        // 마지막에 .build를 해줘야 한다
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 비지니스 로직
        // Todo 데이터를 들고 오는것
        // 초기화 된 레트로핏 object와 비지니스 로직인 인터페이스 연결
        service = retrofit.create(RetrofitService.class);
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG", response.isSuccessful() + "<---");
                if(response.isSuccessful()){
                    // Gson(타입변환 코드를 안쓰고있다!!!!)
                    Todo todo = response.body().get(0);
                    Log.d("TAG", "userId : " + todo.userId);
                    Log.d("TAG", "title : " + todo.title);
//                    textView1.setText(todo.title);
                    textView.setText(todo.userId  + "\n" + todo.title);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                // 통신이 실패하면 여기로 온다
                Log.d("TAG", "실패 : " +  t.getMessage());
            }
        });

        // Post 데이터를 들고 오는것
        // Users 데이터를 들고 오는것

    }
}