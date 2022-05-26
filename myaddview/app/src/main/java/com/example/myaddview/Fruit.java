package com.example.myaddview;

import java.util.ArrayList;

public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit(String imageUrl, String name, String price, String count){
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.count = count;
    }
//    샘플 데이터 만들어 보기
    public static ArrayList<Fruit> getFruits(){
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/08/04/23/43/watermelon-3584717__340.jpg","수박","10000","2"));
        list.add(new Fruit("https://media.istockphoto.com/photos/full-frame-shot-of-red-apples-picture-id1290335922?b=1&k=20&m=1290335922&s=170667a&w=0&h=moBoSE4fx7uCe5slP0dXgR0hncEzFXQFWHxNLeq8gsU=","사과","1200","10"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/04/09/07/30/chaise-mans-2215042__340.jpg","망고","2300","7"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2015/06/17/10/15/cantaloupe-812214__340.jpg","멜론","12000","4"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2021/02/10/16/48/melon-6002760__340.jpg","참외","1200","15"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/08/22/13/58/grapes-3623694__340.jpg","포도","2000","11"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/03/26/16/44/tomatoes-1280859__340.jpg","방울토마토","100","50"));

        return list;
    }

}
