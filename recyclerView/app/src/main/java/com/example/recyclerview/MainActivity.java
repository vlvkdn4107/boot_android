package com.example.recyclerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview.adapter.FoodAdapter;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;
import java.util.ArrayList;

/*
 * RecyclerView
 *
 * -장점
 * listView 개선판
 *  ViewHolder 포함 (findviewById를 줄이기위한것)
 *  유연하다
 *  스크롤뷰도 알아서 잡아준다
 *  LayoutManager, Adapter클래스 2가지가 필요하다
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoodAdapter foodAdapter = new FoodAdapter(Food.getSampleData(), this, new OnFoodItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                //위에 어댑터를 생성해면 여기가 호출 되어 진다.
                Log.d("TAG","넘겨받은 포지션" + position);
                Intent intent = new Intent(getApplication(), DetailActivity.class);
                startActivity(intent);
//                오브젝트 단위로는 못던진다! 하지만 Food클래스에 implements Serializable 를 사용하면된다
//                intent.putExtra("obj",Food.getSampleData().get(position));
            }
        });
        // 사실 통신으로 JSon받는 부분이다

        ArrayList<Food> listSample = Food.getSampleData();
        //리싸이클러뷰를 사용하기 위해서
        // 1. Adapter 클래스를 직접 생성해야한다.
        // 2. LayoutManager 생성 해서 Adapter클래스와 연결해야 한다.

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(foodAdapter);
//        recyclerView.setAdapter(new FoodAdapter(Food.getSampleData(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}