package com.example.myhttp.models;


    /*
    * https://www.jsonschema2pojo.org/
    * 복잡할때는 2pojo 사용 한다
    *
    *    {
          "userId": 1,
          "id": 1,
          "title": "delectus aut autem",
          "completed": false
          }
    *
    *
    * */

        public class Todo {
            public int userId;
            public int id;
            public String title;
            public boolean completed;
        }
