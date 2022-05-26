package com.example.myaddview2;

import java.util.ArrayList;

public class Car {

    String imageUrl;
    String carName;
    String year;
    String price;
    String km;

    public Car(String imageUrl, String carName, String year, String price, String km){
        this.imageUrl = imageUrl;
        this.carName = carName;
        this.year = year;
        this.price = price;
        this.km = km;
    }

    //샘플 데이터
    public static ArrayList<Car> getCar(){
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAyMDExMjBfMjMw%2FMDAxNjA1ODU1NjQ0NTkw.GQg4lFOufVq4rr2gIX5wS2u3KKR5aBalU-5pd_8D35Eg.PET5P2Nx2I33-HsFBneIUJ1aBcbtHvg2Qumpd5fV1_Ig.JPEG%2F1.jpg&type=a340","(기아)k5","18년식","870만원","38,400km"));
        carList.add(new Car("https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAxODEyMTlfNDgg%2FMDAxNTQ1MTgzMDA0NjM1.xBwBYdViJ_ligFfuUMJJZ6jCCcrcy0JuMr1LA6VgwCgg.uipaYRJxTN0zIkz040xV5BYI_qjaidUmZMah_aPm684g.JPEG.ilolove%2FK-20181219-376380.jpg&type=a340","(현대)그랜저","16년식","1100만원","85,400km"));
        carList.add(new Car("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA2MDVfNzcg%2FMDAxNTkxMzQ0MDk1NTU3.PYGtdk7ywZlp6qU409s3_cmvCVLH7r5sIx1XbqVsL-8g.0l4GZmeKkQWhSW2u-1Z0ad2GjOYUbHBIJrHlyZrHKDgg.JPEG.legendmall%2F20200605_100348.jpg&type=a340","(기아)모하비","20년식","1700만원","57,200km"));
        carList.add(new Car("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTEyMTBfMjE5%2FMDAxNTc1OTQ1MzgxMjYz.D-8z5Rus-7nzYNau0LrvoTrkXtoECDUwr4nU4OVS_Msg.R6sAuZ2-l8GMoQBxWS2MjCSFHcXAShaUJrb6S8rahdgg.JPEG.kwondaean%2F1571306787_1.jpg&type=a340","(쌍용)티볼리","18년식","630만원","128,400km"));
        return carList;
    }


}
