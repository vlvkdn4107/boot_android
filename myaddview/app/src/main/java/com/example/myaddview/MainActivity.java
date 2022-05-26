package com.example.myaddview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fruit> sampleData = Fruit.getFruits();
        // addview 방식으로 할 때는 뷰를 위치시킬 컨테이너 가져 오기
        LinearLayout container = findViewById(R.id.fruitContainer);
        LayoutInflater inflater = LayoutInflater.from(this); // 그냥 new를 한거라고 생각하면된다.



        // forEach 람다식
        sampleData.forEach(fruit -> {
            //View들의 최상위는 View이다
            // inflater 객체를 이용해서 xml 파일을 메모리에 올리고 설정하기
            View itemview = inflater.inflate(R.layout.item_fruit, container,false);

            ImageView fruitImageView = itemview.findViewById(R.id.fruitImageView);

            TextView fruitNameTextView = itemview.findViewById(R.id.fruitNameTextView);
            TextView fruitFrice = itemview.findViewById(R.id.fruitFrice);
            TextView fruitCount = itemview.findViewById(R.id.fruitCount);
            fruitNameTextView.setText(fruit.name);
            fruitFrice.setText("가격 : " + fruit.price);
            fruitCount.setText("수량 : " + fruit.count);
            //이미지 셋팅
            Glide.with(this)
                    .load(fruit.imageUrl)
                    .centerCrop()
                    .into(fruitImageView);
            container.addView(itemview);
        });


    }
}