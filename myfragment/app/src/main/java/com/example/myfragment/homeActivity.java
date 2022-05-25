package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class homeActivity extends AppCompatActivity {
    private FragmentBanner fragmentBanner;
    private FragmentBanner2 fragmentBanner2;
    private Button btnCreate;
    private Button btnDelete;
    private Button btn1;
    private Button btn2;
    private LinearLayout container;
    private LinearLayout container2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);
        container2 = findViewById(R.id.container2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btnCreate.setOnClickListener(view -> {

            fragmentBanner = new FragmentBanner();
            // 플래그먼트를 동적으로 만들기 위해서 필요한 준비물
            // 1. FragmentManager (플래그먼트 트랜색션 객체를 가져올수 있다)
            // 2. FragmanetTransaction / Transaction -> (트랜색션은 작업에 단위이다(시작과 끝이 있다)
            // // 여러개에 부분 부분 작업들을 한 단위로 만들어 준다.)
            FragmentManager manager = getSupportFragmentManager();
            // 실수를 방지 하기 위해 new를 쓰지않고 getSupportFragmentManager를 쓴다.
            FragmentTransaction transaction = manager.beginTransaction();
            // manager.beginTransaction() -> 지금 부터 트랜색션 처리를 할꺼야!!

            // 실행 코드 xml파일에 만들어둔 영역(view Component)에 올려라
            transaction.replace(R.id.container,fragmentBanner);
            // 반드시 transaction을 커밋해줘야한다
            transaction.commit(); // 시간이 될때 완료 해!!!(시스템에 요청) (권장)
//            transaction.commitNow(); // 지금 당장 해!!!(시스템에 요청) (오류들이 발생할수있음)
//            transaction.commitAllowingStateLoss(); // 위험!!!(커밋이 없어질수있다 쓰지않음!)
        });
        // 플래그먼트 제거!!
        btnDelete.setOnClickListener(view -> {
            //remove
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentBanner);
            // 삭제는 remove detach 2개가 있는데 거의 remove를 쓴다
            transaction.commit();
        });

        btn1.setOnClickListener(view -> {
            fragmentBanner2 = new FragmentBanner2();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container2,fragmentBanner2);
            transaction.commit();
        });
        btn2.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentBanner2);
            transaction.commit();
        });
    }
}