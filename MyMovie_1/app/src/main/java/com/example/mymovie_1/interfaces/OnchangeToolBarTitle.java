package com.example.mymovie_1.interfaces;

// 1. 콜백 메서드 만들때 인터페이스를 먼저 선언한다!
// 1-1 추상메서드를 선언 한다!.(구분해야될 부분이나 데이터를 전달해야 할 경우 매게변수를 만들어 준다.)
// 2. 호출자에 가서 이 인터페이스를 멤버변수로 선언
// 2-1 필요한 곳에서 이 인터페이스안에 속해있는 추상 메서드를 호출 하면 된다.
// (MovieFragmetn, InfoFragment) << 이 두 클래스가 호출자가 된다
public interface OnchangeToolBarTitle {
    // 한번 코드를 짤때 확장성있게,유지보수 편하게 생각을 해본다!.
    void onSetupType(String title);
    // 플레그먼트 --> 메서드 호출(MovieFragment(MOVIE),InfoFragment(INFO)........값만 던지며 된다!
    // 메인 엑티비티에서 콜백 받음
}
