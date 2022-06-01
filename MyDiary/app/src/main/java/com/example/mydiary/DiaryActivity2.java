package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity2 extends AppCompatActivity {


    EditText diaryEditText;
    // 핸들러 (Looper - 메세지 큐 한테 계속 던지는 놈이다)
    // FIFO(first input first output)
    Handler handler = new Handler(Looper.getMainLooper());
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);
        initData();
        addEventListener();
    }

    private void initData(){
        diaryEditText = findViewById(R.id.diaryEditText);
    }
    private void addEventListener() {
        // 사용자가 이전에 적었던 비밀 일기장 불러와야한다.
        SharedPreferences notePreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(notePreferences.getString("detail",""));
        
        // 쓰레드 기능 구현 (여기서 부터
        Runnable runnable = () -> {
            // 한글자 한글자 들어올때마다 SharedPreferences에 저장 할 예정
            SharedPreferences preferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("detail",diaryEditText.getText().toString());
            editor.apply();
            // 새로운 쓰레드를 만들어서 비동기로 저장하게 만들기!
            // 쓰레드 간에 통신 해보기
        };// 여기까지 다른 영역이다)


        
        // 중요한거! addTextChangedListener(new TextWatcher()
        // 사용자가 한글자 한글자 입력할때마다 이벤트 리스너를 등록해서 변경사항을 가지고 오기
        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG","char : " +  s);
                Log.d("TAG","char1 : " +  start);
                Log.d("TAG","char2 : " +  count);
                Log.d("TAG","char3 : " +  after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 여기에서 다른 스레드한테 일 해달라고 요청 함!
                // 핸들러
                // 쓰레드를 통으로 핸들러 한테 던지고 핸들러는 메세지 큐로 던진다.

//                handler.post(runnable);
                // a: 0.5초 딜레이
                // ab : 0.5초 딜레이 -- 삭제
                // abc : 0.5초 딜레이 -- 삭제
                // abcd : 0.5초 딜레이 -- 이거만 저장시킴! << 이놈이 removeCallbacks
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,500);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}