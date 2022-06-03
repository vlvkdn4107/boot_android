package com.example.mymovie_1;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mymovie_1.databinding.FragmentInfoBinding;
import com.example.mymovie_1.interfaces.OnPassWebView;
import com.example.mymovie_1.interfaces.OnchangeToolBarTitle;
import com.example.mymovie_1.utills.Define;


public class InfoFragment extends Fragment {
    private FragmentInfoBinding binding;
    private MainActivity mainActivity;
//    OnInfoItemClicked onInfoItemClicked;
    private OnchangeToolBarTitle onchangeToolBarTitle;

    //싱글톤
    private static InfoFragment infoFragment;

    private WebView webView;
    private OnPassWebView onPassWebView;

    public void setOnPassWebView(OnPassWebView onPassWebView) {
        this.onPassWebView = onPassWebView;
    }

    // 메서드를 통해서 callback 보내는 방법
//    public void setOnchangeToolBarTitle(OnchangeToolBarTitle onchangeToolBarTitle) {
//        this.onchangeToolBarTitle = onchangeToolBarTitle;
//    }

    public InfoFragment(OnchangeToolBarTitle onchangeToolBarTitle) {
        this.onchangeToolBarTitle = onchangeToolBarTitle;
    }

    public static InfoFragment getInstance(OnchangeToolBarTitle onchangeToolBarTitle) {
        if(infoFragment == null){
            infoFragment = new InfoFragment(onchangeToolBarTitle);
        }
        return infoFragment;
//        InfoFragment fragment = new InfoFragment(onchangeToolBarTitle);
//        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 콜백으로 topBar 타이틀 변경
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 뷰 결합하기 위해 메모리 초기화
       binding = FragmentInfoBinding.inflate(inflater, container, false);
       onchangeToolBarTitle.onSetupType(Define.PAGE_TITLE_INFO);
        setUpWebView();
//        onBackPressedCallback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                Log.d("TAG","handleOnBackPressed");
//            }
//        };
//        // 현재 엑티비티에 onchangeToolBarTitle << 이놈을 넣는다!
//        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),onBackPressedCallback);
        return binding.getRoot();
    }
    private void setUpWebView(){
        webView = binding.webView;
        webView.loadUrl("https://yts.mx/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 콜백
                binding.Loding.setVisibility(View.GONE);

            }
        });
        // 자바스크립트 허용 코드 넣어줘야 뒤로가기했을때 다시 info로 돌아간다.
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // 이시점에 콜백이 호출되서 main엑티비티 까지 간다
        onPassWebView.onPassWebViewObj(webView);
    }


}