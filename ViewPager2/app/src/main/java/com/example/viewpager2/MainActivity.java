package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.Adapter.ImageSliderAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<>();
    private  LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images.add("https://search.pstatic.net/common?type=o&size=174x246&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20220516_144%2F1652665409592Chvey_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
        images.add("https://search.pstatic.net/common?type=o&size=174x246&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20220504_33%2F165164173504831gKe_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
        images.add("https://search.pstatic.net/common?type=o&size=174x246&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20220510_209%2F1652173423913czGcU_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
        images.add("https://search.pstatic.net/common?type=o&size=174x246&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20220506_169%2F16518204621480DxEQ_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
        images.add("https://search.pstatic.net/common?type=o&size=174x246&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20220516_144%2F1652687286550mcE4G_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);
        sliderImageViewPager = findViewById(R.id.sliderViewPager2);
        sliderImageViewPager.setOffscreenPageLimit(2);
        sliderImageViewPager.setAdapter( new ImageSliderAdapter(this,images));
        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);

            }
        });
        setupIndicators(images.size());
        }

    private void setupIndicators(int count){
        ImageView[] indicators = new ImageView[count];
        //LayoutParams
        // 뷰가 어떻게 배치 될지 정의하는 속성
        // xml 파일에서 loyout. 붙는 속성들을 말한다.
        // LayoutParams 객체를 통해서 다룰수있다
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(16,8,16,8);
        for(int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.test));
            //imageView 오브젝트
            indicators[i].setLayoutParams(params);

            layoutIndicatorsContainer.addView(indicators[i]);
        }
    }// end of setupIndicators

    private void setCurrentIndicator(int position){
        int childCount = layoutIndicatorsContainer.getChildCount();
        for(int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i);
            if(i == position){
                imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.test));
            }else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.test2));
            }
        }
    }
}