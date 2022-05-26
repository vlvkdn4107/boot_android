package com.example.recyclerview2.model;

import java.util.ArrayList;

public class Accommodation {

private String thumbnail;
private String title;
private String where;
private String subtitle;
private String price;


    public Accommodation(String thumbnail, String title, String where, String price, String subtitle) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.where = where;
        this.price = price;
        this.subtitle = subtitle;

    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public ArrayList<Accommodation> getSampleData(){
        ArrayList<Accommodation> Accommodations = new ArrayList<>();
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/adimg_new/66917/350129/02c8ad67b7f8c6c7083bea2f7f8adabb.jpg","숙박1","부산 서면","120,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2021/05/07/6094c1a7028c3.jpg","숙박2","부산 해운대","120,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2021/04/22/6080f4f4c499a.jpg","숙박3","부산 서면","80,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2020/11/12/5facd1c4769bd.jpg","숙박4","부산 광안리","150,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2019/02/08/5c5ce55851119.jpg","숙박5","부산 사상","70,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2017/01/04/586c4a4b576ff.jpg","숙박6","부산 덕천","70,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2021/02/03/601a1e603ab4f.jpg","숙박7","부산 해운대","150,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2021/07/26/60fe6d0fb5bf4.jpg","숙박8","부산 해운대","170,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/adimg_new/70794/446729/cb48b77a1f40854314556007304f472f.jpg","숙박9","부산 광안리","100,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/affiliate/2019/04/24/5cbfa91f131e0.jpg","숙박10","부산 광안리","120,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
        Accommodations.add(new Accommodation("https://image.goodchoice.kr/resize_1000X500x0/adimg_new/61892/10346/d99f53ceac103e74aff0947cb9b85c39.jpg","숙박11","부산 서면","110,000원","넷플릭스 어쩌구 저쩌구 어쩌구 저쩌구"));
                return  Accommodations;
    }
}
