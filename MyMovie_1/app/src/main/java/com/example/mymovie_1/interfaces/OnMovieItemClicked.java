package com.example.mymovie_1.interfaces;

import com.example.mymovie_1.models.Movie;

public interface OnMovieItemClicked {

    // 콜백으로 이벤트 만들기! (MovieAdapter)
    void selecteditem(Movie movie);
}
