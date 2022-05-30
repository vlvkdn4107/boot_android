package com.example.myretrofit2.repository.service;

import com.example.myretrofit2.repository.models.Post;
import com.example.myretrofit2.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    // https://jsonplaceholder.typicode.com/todos
    // 응답 요청해서 받을 때는 무조건 Call
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    // https://jsonplaceholder.typicode.com/todos/(id)
    // 요청
    @GET("todo/{id}")
    Call<Todo> getTodo(@Path("id") int id);
    /*
    *
    "userId": ,
    "id":,
    "title": ,
    "body":
    * */
    // https://jsonplaceholder.typicode.com/posts
    // 모바일 --> 서버에 내 정보를 데이터 베이스에 입력 요청
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId")int userId,
            @Field("Id")int Id,
            @Field("title") String title,
            @Field("body") String body
    );

}
