package com.example.comicreader.View;

import com.example.comicreader.Model.Manga;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("https://www.mangaeden.com/api/list/0/")
    Call<Manga> getMangaList();
}
