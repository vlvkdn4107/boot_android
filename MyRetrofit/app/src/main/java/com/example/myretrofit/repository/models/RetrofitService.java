package com.example.myretrofit.repository.models;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    
    // https://jsonplaceholder.typicode.com/todos << 이주소가 된다.
    @GET("todos")
    // 함수명 (retrun 타입이다)
    Call<ArrayList<Todo>> getTodos();

}
