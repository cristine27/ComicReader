package com.example.comicreader.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class KumpulanManga {
    @SerializedName("end")
    public int end;

    @SerializedName("manga")
    public List<Manga> kumpulanManga = new ArrayList<>();

    @SerializedName("page")
    public int page;

    @SerializedName("start")
    public int start;

    @SerializedName("total")
    public int total;
}
