package com.example.mydiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    private AppCompatButton openBtn;
    private AppCompatButton changePasswordBtn;

    private SharedPreferences passwordPreferences;
    private static final String KEY_PWD = "password";

    private String passwordFormUser;



    // 프로그램 흐름상
    private boolean changePasswordMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        initData();
        addEventListener();
    }
    private void initData(){
        numberPicker1 = findViewById(R.id.number_picker1);
        numberPicker2 = findViewById(R.id.number_picker2);
        numberPicker3 = findViewById(R.id.number_picker3);
        numberPicker1.setMaxValue(9);
        numberPicker1.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker3.setMaxValue(9);
        numberPicker3.setMinValue(0);
        openBtn = findViewById(R.id.openBtn);
        changePasswordBtn = findViewById(R.id.changeBtn);

        passwordPreferences = getSharedPreferences(KEY_PWD,Context.MODE_PRIVATE);
    }
    private void addEventListener(){
        // 비밀 다이어리 오픈 버튼 불렀을 때 동작 처리
        openBtn.setOnClickListener(event -> {
            if(changePasswordMode){
                // 작은 버튼 눌러서 색상이 변경 되었을때 진행 시키면 안된다.
                Toast.makeText(this, "비밀번호 변경 중 입니다.", Toast.LENGTH_SHORT).show();
                // 실행의 흐름을 막기 위해 리턴
                return;
            }
            // 저장 되어있는 패스워드 데이터를 불러 와서 확인 해야 한다.
            // 패스워드 저장하는 방식 - 로컬 DB(SQL Lite), 쉐어드 프리퍼런스
            // 프로그램을 끄더라도 영속성을 가진 데이터베이스나 쉐어드 프리퍼런스를 사용함!
//            passwordPreferences = getSharedPreferences
//                                                    ("password", Context.MODE_PRIVATE);


            // 메서드화 해서 처리
            passwordFormUser = getUserNumber();
//            String passwordFormUser = "" + numberPicker1.getValue()
//                                         + numberPicker2.getValue()
//                                         + numberPicker3.getValue();
            // 값을(비밀번호를)셋팅 하지 않았을 경우! 초기값 셋팅으로 처리
            // 000 <---> 000 : ok
            // 333 <---> 123 : no!
            if(passwordPreferences.getString(KEY_PWD,"000").equals(passwordFormUser)){
                // 여기로 들어온다는 말은 패스워드 확인이 성공 했다는 말이다.
                Intent intent = new Intent(this,DiaryActivity2.class);
                startActivity(intent);
            }else{
                // 패스워드가 틀렸으면
//                Toast.makeText(this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                showErrorAlertDialog();
            }

        });
        // 비밀번호 변경 버튼 눌렀을때 동작 처리
        changePasswordBtn.setOnClickListener(event -> {
            passwordFormUser = getUserNumber();
            // 비밀번호를 변경 중인 경우, 처음 변경하곘다고 누르는 경우
            if(changePasswordMode){
                // 비밀번호 변경하는 경우 ---> 저장처리하는 부분
                SharedPreferences.Editor editor = passwordPreferences.edit();
                editor.putString(KEY_PWD,getUserNumber());
                editor.apply();
                changePasswordMode = false;
                changePasswordBtn.setBackgroundColor(Color.BLACK);
                Toast.makeText(this, "비밀번호 변경이 완료 되었습니다", Toast.LENGTH_SHORT).show();
            }else{
                // 비밀변경 모드 활성화 시키기
                // 단, 현재 넘버피커 숫자가 내가 정한 비밀번호와 일치해야
                // 변경 모드로 만들어 줘야 한다.
                if(passwordPreferences.getString(KEY_PWD,"000").equals(passwordFormUser)){
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    changePasswordBtn.setBackgroundColor(Color.RED);
                }else{
                    showErrorAlertDialog();
                }
            }
        });

    };
    private void showErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패!")
                .setMessage("비밀번호가 잘못 되었습니다.")
                .setPositiveButton("닫기",(dialog, which) -> {
                    // 동작 정의 안함!

                });
        builder.show();
    }
    private String getUserNumber(){
        String passwordFromUser = "" + numberPicker1.getValue()
                + numberPicker2.getValue()
                + numberPicker3.getValue();
        Log.d("TAG","비밀번호 : " + passwordFromUser);
        return  passwordFromUser;
    }
}