package com.example.weekendstudent.sampleData;

import java.util.ArrayList;

public class Sample {

    String imgURL;
    String title;
    String subtext;
    String price;

    public Sample(String imgURL, String title, String subtext, String price) {
        this.imgURL = imgURL;
        this.subtext = subtext;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "imgURL='" + imgURL + '\'' +
                ", title='" + title + '\'' +
                ", subtext='" + subtext + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public static ArrayList<Sample> getSample(){
        ArrayList<Sample> profilesample = new ArrayList<>();
        profilesample.add(new Sample("https://s.pstatic.net/shopping.phinf/20220527_24/ac23688e-d9f2-42d4-a6e0-5cc0eb58033c.jpg","Title1","subtitle1","10000원"));
        profilesample.add(new Sample("https://s.pstatic.net/shopping.phinf/20211206_5/c9a6c243-66fc-4249-b0a3-6b8d8535d0bc.jpg","Title2","subtitle2","15000원"));
        profilesample.add(new Sample("https://s.pstatic.net/shopping.phinf/20220520_10/ee9333da-63c9-4272-8ae9-7686d931ff4e.jpg","Title3","subtitle3","22000원"));
        profilesample.add(new Sample("https://s.pstatic.net/shopping.phinf/20220518_26/fde1e7eb-5454-4503-931b-0a226fb57eb2.jpg","Title4","subtitle4","13000원"));
        profilesample.add(new Sample("https://g-selected.pstatic.net/MjAyMjA1MjNfMTk5/MDAxNjUzMjkwMjI4NTE2.Rpqr0VDzLq1SdAhOKf8uHTqscvrdV_HnTW6QPhqG6REg.cSUrbT5n240fowMaUseNhV2u7SE5YlbcwIPtiXIIxEQg.PNG/image.png?type=f320_480_q90","Title5","subtitle5","7000원"));
        profilesample.add(new Sample("https://g-selected.pstatic.net/MjAyMjA1MTBfMTA1/MDAxNjUyMTU5NTcyMjUw.ZR2fK2NbWq__3LYXPlbtdV_elwvSs5wHfhKn1u0BD1kg._EEi7su113gNSrbnw9y4XLILUxgZRnSoFwpxPJmXiP4g.PNG/live_up1.png?type=f320_480_q90","Title6","subtitle6","33000원"));
        profilesample.add(new Sample("https://shopv.pstatic.net/web/cnsv/iu/home/22/0525/2y3z094sjcm.jpg","Title7","subtitle7","13200원"));
        return profilesample;
    }
}
