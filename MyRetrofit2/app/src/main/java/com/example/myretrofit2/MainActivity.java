package com.example.myretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretrofit2.repository.models.Post;
import com.example.myretrofit2.repository.models.Todo;
import com.example.myretrofit2.repository.service.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Retrofit retrofit;
    RetrofitService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        // 객체 초기화
        // GsonConverterFactory 는 레트로핏에서 만든놈
        retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 인터페이스를 익명구현 객체로 만들어서 사용하는 부분임!
        service = retrofit.create(RetrofitService.class);

//         Retrofit 사용 밥법
//         단 동시에 호출하면 error
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                if(response.isSuccessful()){
                    Log.d("TAG",response.body().toString());

                    // 자동 파싱된다!!
                    ArrayList<Todo> list = response.body();
                    Log.d("TAG",list.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });

//         path vailable 방식으로 데이터 요청 후 응답 후 처리
//        service.getTodo(20).enqueue(new Callback<Todo>() {
//            @Override
//            public void onResponse(Call<Todo> call, Response<Todo> response) {
//                if(response.isSuccessful()){
//                    Todo todo = response.body();
//                    Log.d("TAG","todo" + todo.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Todo> call, Throwable t) {
//
//            }
//        });
//        createPost();

    } // end of onCreate
//    private void createPost(){
//        // 데이터를 서버로 요청!
//        Call<Post> call = service.createPost(
//                8000,8001,"오늘 치맥","친구랑 8시 약속");
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                if(response.isSuccessful()){
//                    Log.d("TAG", "데이터 저장 성공");
//                    Log.d("TAG", response.body().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//            }
//        });

//    }
}