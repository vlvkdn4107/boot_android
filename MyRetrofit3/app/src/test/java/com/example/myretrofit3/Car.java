package com.example.myretrofit3;

public class Car {
    private String name;
    private int price;

    // 1. 기본생성자를 private으로 정의
    private Car(){}
    // 2. 내부 클래스 생성 (static으로)
    public static class MyBuilder{
        // 2_1 outclass 의 멤버 변수를 한번더 정의한다(private)
        private String name;
        private int price;
        // 2_2 setter메서드를 만들어준다(리턴 타입은 this로)
        public MyBuilder setName(String name){
            this.name = name;
            return this;
        }
        public MyBuilder setPrice(int price){
            this.price = price;
            return this;
        }
        // 3. 핵심 (리턴 타입을 out class로 반환하는 메서드만들기)
        public Car build(){
            Car car = new Car();
            car.name = name; // out class name = inner class name;
            car.price = price;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new MyBuilder().setName("좋은차").build();
        Car car1 = new MyBuilder().setPrice(10000).build();
        Car car2 = new MyBuilder().setName("비싼차").setPrice(100000).build();
    }
}
