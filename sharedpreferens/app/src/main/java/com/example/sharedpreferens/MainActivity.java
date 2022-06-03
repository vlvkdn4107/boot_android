package com.example.sharedpreferens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnLoad;
    private Button btnDelete;
    private Button btnDeleteAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

        //SharedPreferences
        // 생성 방법
        //메모리 올리기 getSharedPreferences()하면 알아서 new 처리를 해준다
        SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
        // MODE
        // - MODE_PRIVATE : 생성한 어플리케이션에서만 사용가능하다
        // - MODE_WORLD_READABLE : 다른 앱에서 사용가능 하지만 읽을수만 있다.
        // - MODE_WORLD_WRITEABLE : 다른 앱에서 사용가능 하지만 읽을수도있고 기록도 가능하다.

        // 데이터를 입력 해보기!!
        // 데이터를 넣기위해 수정모드로 먼저 만들어야한다. Editor
        SharedPreferences.Editor editor = sp1.edit();
        editor.putString("name", "홍길동");
        // 여기까지 해도 저장이안된다. Editor에 접근해서 commit 까지 해줘야 저장이 된다.
        editor.apply();
//        editor.commit();
        // 여기까지 하면 어딘가에 name이라는 key값과 "홍길동"이라는 value값이 저장되었다
        // 꺼내는 코드는 btnLoat 이벤트쪽

        // apply() 와 commit()의 차이점
        // apply() -> 쓰레드를 블록 시키지 않는다.
        // (어떠한 쓰레드가 작업을 하고있는데 apply는 막지 않는다 비동기 방식으로 움직인다)
        // (대신 저장에 성공 여부 true, false 값을 주지 않는다)

        // commit() -> 쓰레드가 블록 된다.
        // (동기박식으로 된다. 다만 commit은 저장을 성공하면 boolean 타입인 true 값을 반환한다)

    }

    private void initData() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
    }

    private void addEventListener() {
        btnSave.setOnClickListener(view -> {
            // 1. 세어드프리퍼런스 객체를 불러온다(이름, 모드)
            // 2. 수정 모드로 만들어 줘야한다.
            // 3. 저장할 데이터를 입력한다.
            // 4. 비동기방식으로 데이터를 완전히 저장한다.
            // name, age, isMarried 데이터를 저장 하는 기능을 만들어 주세요

            getShared("sp1")
                    .edit().putString("name", "이순신")
                    .putInt("age",30)
                    .putBoolean("isMarried", true).apply();

//            SharedPreferences savePreferences = getSharedPreferences("sp1", MODE_PRIVATE);
//            SharedPreferences.Editor saveEditor = savePreferences.edit();
//            saveEditor.putString("name", "이순신");
//            saveEditor.putInt("age", 35);
//            saveEditor.putBoolean("isMarried", true);
//            saveEditor.apply();
        });
        btnLoad.setOnClickListener(view -> {
            // 값을 꺼내는 코드
            SharedPreferences preferences = getSharedPreferences("sp1",MODE_PRIVATE);
            // 데이터 읽어보기
            String name = preferences.getString("name", "없음");
            int age = preferences.getInt("age", 0);
            Toast.makeText(this, "age : " +  age, Toast.LENGTH_SHORT).show();
            boolean isMarried = preferences.getBoolean("isMarried", false);
            Log.d("TAG", "LoadBtn name 값 확인 : " + name);
            Log.d("TAG", "LoadBtn age 값 확인 : " + age);
            Log.d("TAG", "LoadBtn isMarried 값 확인 : " + isMarried);

        });
        btnDelete.setOnClickListener(view -> {
            // 메서드 체이닝 방식으로 코드 작성해 보기
            // age <-- 삭제
            getShared("sp1").edit().remove("age").apply();
            getShared("sp1").edit().remove("name").apply();
            // 잘 삭제가 되었는지 확인하기 !!
            // 코드상으로 버튼을 눌렀다 명령하기
            btnLoad.callOnClick();
        });
        btnDeleteAll.setOnClickListener(view -> {
            // 전부 삭제
            getShared("sp1").edit().clear().apply();
            // 코드상으로 버튼을 눌렀다 명령하기
            btnLoad.callOnClick();
        });
    }

    // 반복적인  SharedPreferences를 메서드화
    private SharedPreferences getShared(String name){

        return  getSharedPreferences(name, MODE_PRIVATE);
    }

}