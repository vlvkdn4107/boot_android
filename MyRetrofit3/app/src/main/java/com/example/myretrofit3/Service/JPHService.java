package com.example.myretrofit3.Service;

import com.example.myretrofit3.models.reqeust.ReqPostDto;
import com.example.myretrofit3.models.response.ResponsePostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

//https://jsonplaceholder.typicode.com/
public interface JPHService {

    // 레트로핏 초기화
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // 주소 설계
    // https://jsonplaceholder.typicode.com/posts/{id}
    // id로 하나만
    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id")int id);

    //https://jsonplaceholder.typicode.com/posts
    // 전부다
    @GET("posts")
    Call<List<ResponsePostDto>> postList();

    // https://jsonplaceholder.typicode.com/posts/{postid}
    // HTTP 메세지 body 부분에 데이터를 넣어서 서버에 전달 한다. ( MINE_TYPE 은 json형식으로 보냄)
    // 우리의 데이터가 잘 전달 되었다면 서버측에서는 응답 값을 보내준다.
    // 값을 보낼 때 어떻게 데이터를 보낼지 설계 해야 한다.
    @POST("posts")
    Call<ResponsePostDto> createPost(@Body ReqPostDto reqPostDto);

    @PUT("posts/{postId}")
    Call<ResponsePostDto> updatePost(@Path("postId")int postId, @Body ReqPostDto reqPostDto);

    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId")int postId);

//    @FormUrlEncoded
//    @POST("/posts")
//    Call<List<ResponsePostDto>> serchByUserId1(@Field("userId")int userId);




}
