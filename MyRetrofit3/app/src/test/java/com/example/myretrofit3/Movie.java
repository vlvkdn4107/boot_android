package com.example.myretrofit3;

public class Movie {
    private String name;
    private String actor;

    private Movie(){}

    public static class MyBuilder1{
        private String name;
        private String actor;

        public MyBuilder1 setName(String name){
            this.name = name;
            return this;
        }
        public MyBuilder1 setActor(String actor){
            this.actor = actor;
            return this;
        }
        public Movie build1(){
            Movie movie = new Movie();
            movie.name = name;
            movie.actor = actor;
            return movie;
        }
    }

    public static void main(String[] args) {
        Movie movie = new MyBuilder1().setName("명량").setActor("최민식").build1();
    }
}
