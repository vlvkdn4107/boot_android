package com.example.myretrofit3.models.response;

/*
* {
      "userId": 1,
      "id": 1,
      "title":
      "body":
  }
*
*
* */
public class ResponsePostDto {

    public int userId;
    public int id;
    public String title;
    public String body;

    @Override
    public String toString() {
        return "ResponsePostDto{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
