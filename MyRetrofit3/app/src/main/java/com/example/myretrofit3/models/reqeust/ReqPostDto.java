package com.example.myretrofit3.models.reqeust;

/*
* title: 'foo',
    body: 'bar',
    userId: 1,
    *
    * Activity(모바일) --> 객체를 생성해서 --> 서비스 로직 매게변수에 전달 하는 코드를 사용
    * 객체를 생성해서 보내야 한다.
* */
public class ReqPostDto {
    public String titls;
    public String body;
    public Integer userId;

    public ReqPostDto(String titls, String body, Integer userId) {
        this.titls = titls;
        this.body = body;
        this.userId = userId;
    }
}
