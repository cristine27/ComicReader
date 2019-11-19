package com.example.comicreader.Model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class KumpulanManga {
    @SerializedName("end")
    public String end;

    @SerializedName("manga")
    public JsonObject kumpulanManga = new JsonObject();

    @SerializedName("page")
    public String page;

    @SerializedName("start")
    public String start;

    @SerializedName("total")
    public String total;

    public KumpulanManga(String end, JsonObject manga, String page, String start, String total){
        this.end = end;
        this.kumpulanManga = manga;
        this.page = page;
        this.start = start;
        this.total = total;
    }
}
