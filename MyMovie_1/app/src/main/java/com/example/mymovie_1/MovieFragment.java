package com.example.mymovie_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mymovie_1.adapter.MovieAdapter;
import com.example.mymovie_1.databinding.FragmentMovieBinding;
import com.example.mymovie_1.interfaces.OnMovieItemClicked;
import com.example.mymovie_1.interfaces.OnchangeToolBarTitle;
import com.example.mymovie_1.models.Movie;
import com.example.mymovie_1.models.YtsData;
import com.example.mymovie_1.repository.MovieService;
import com.example.mymovie_1.utills.Define;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment implements OnMovieItemClicked{

    // 안드로이드에서 만들어준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();
    // 불변성을 유지하기 위해 final 을 선언한다

    // 여기서 통신 요청을 할 예정
    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    private int currentPageNumber = 1;
    // 스크롤시 중복 이벤트 발생 해결 방안!!
    private boolean scrollEvent = true;

    private OnchangeToolBarTitle onchangeToolBarTitle;
    // 싱글톤 패턴 만들기
    private static MovieFragment movieFragment;

    // 한번 요청했으면 한번 더 요청안하게 만들기! (로딩바)
    private boolean isFirestLoding = true;

// 메서드를 통해 callBack 호출 방법
// setter 만들어줘서 main에서 호출 하면 끝!
    public void setOnchangeToolBarTitle(OnchangeToolBarTitle onchangeToolBarTitle) {
        this.onchangeToolBarTitle = onchangeToolBarTitle;
    }





    // 생성자를 통해서 callBack 보내는 방법
    public MovieFragment(OnchangeToolBarTitle onchangeToolBarTitle) {
        this.onchangeToolBarTitle = onchangeToolBarTitle;
    }



    public static MovieFragment getInstance(OnchangeToolBarTitle onchangeToolBarTitle) {
        // 위에는 메서드 이다 (static 메서드를 통해서 new Fragment()를 하고있는거다.
//        MovieFragment fragment = new MovieFragment(onchangeToolBarTitle);
//        return fragment;

        // 싱글톤 패턴으로 만들기
        if (movieFragment == null){
            movieFragment = new MovieFragment(onchangeToolBarTitle);
        }
        return movieFragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewById 대체(뷰 바인딩 활용)
        // inflater.inflate(R.layout.fragment_movie, container, false)
        binding = FragmentMovieBinding.inflate(inflater, container, false);

        // 리싸이클러 뷰 만들어 주기
        // 아직 없음 // (안드로이드는 입체적으로 생각해야한다)
        setupRecyclerView(list);

        if(isFirestLoding){
            // 통신 해주는놈
            requestMoviesData(currentPageNumber);
        }else{
            setVisiblityProgressBar(View.GONE);
        }


        // 여기까지만 하면 nullpointExepction이 뜬다 주소 연결까지 해줘야 한다.(누가 내 메서드를 callBack받을지
        // 연결 해줘야 nullpointExepction 오류가 안뜬다
        // 연결방법은 2가지
        // 1 생성자
        // 2 메서드
        onchangeToolBarTitle.onSetupType(Define.PAGE_TITLE_MOVIE);

        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {
        int ITEM_LIMIT = 10;
        Log.d(TAG,"통신요청!!!!!");
        movieService.repoContributors("rating", ITEM_LIMIT, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            // 통신을 통해서 데이터를 넘겨 받았으면 adapter에 데이터를 전달해서
                            // 화면을 갱신 처리
                            List<Movie> list = response.body().getData().getMovies();
                            movieAdapter.addItem(list);
                            currentPageNumber++;
                            scrollEvent = true;
                            isFirestLoding = false;
                            setVisiblityProgressBar(View.GONE);

                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                        setVisiblityProgressBar(View.GONE);
                        // xml --> TEXT.VIEW = 네트워크가 불안정 합니다.(Visible.show)
                    }
                });
    }


    // 통신해서 Json 파싱한다음 받은 다음에 메게변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 준비물
        // 1. 어댑터
        movieAdapter = new MovieAdapter();
        // implements 받아서 this 가 가능하다!
        movieAdapter.setOnMovieItemClicked(this);
        movieAdapter.initItemList(movieList);
        // 2. 매니저
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        // 3. xml 파일에 선언한 recyclerview 에 셋팅
        RecyclerView recyclerView = binding.movieRecyclerView;
        recyclerView.setAdapter(movieAdapter);
        binding.movieRecyclerView.setLayoutManager(manager);
        binding.movieRecyclerView.hasFixedSize();
        // 이벤트 리스너
        binding.movieRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollEvent) {
                    LinearLayoutManager layoutManager = ((LinearLayoutManager) binding.movieRecyclerView.getLayoutManager());
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, lastVisibleItemPosition + "@");
                    // adapter (데이터) list.size 로 뽑아올수있다
                    // 리니어 레이아웃은 인덱스 번호로 9를 뽑아 오기 때문에 -1을 붙여줘야한다
                    int itemTotalCount = binding.movieRecyclerView.getAdapter().getItemCount() - 1;
                    if (lastVisibleItemPosition == itemTotalCount) {
                        if (currentPageNumber != 1) {
                            // 난중에 네트워크를 요청할껀데 이벤트가 계속 발생하면 네트워크 오류가 발생할수도있다!.
                            scrollEvent = false;
                            requestMoviesData(currentPageNumber);
                        }

                    }

                }

            }
        });

    }
    // progressBar 없애기!
    private void setVisiblityProgressBar(int visible){
        binding.progressIndicator.setVisibility(visible);
    }


    @Override
    public void selecteditem(Movie movie) {
        Log.d(TAG, " movie : " + movie.getTitle());
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        // 직렬화 --> object --> byte 단위로 변환 해서 던진다!.
        intent.putExtra(MovieDetailActivity.PRAM_NAME_1,movie);
        startActivity(intent);
    }
}
