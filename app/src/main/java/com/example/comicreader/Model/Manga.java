package com.example.comicreader.Model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    @SerializedName("a")
    public String alias;

    @SerializedName("c")
    public List<Category> categories = new ArrayList<>();

    @SerializedName("h")
    public Integer hits;

    @SerializedName("i")
    public String id;

    @SerializedName("im")
    public String image;

    @SerializedName("ld")
    public Double lastChapter;

    @SerializedName("s")
    public String status;

    @SerializedName("t")
    public String title;

    public Manga(String a, List<Category> c, int h, String i, String im,Double lastChapter, String s, String t) {
        this.alias = a;
        this.categories = c;
        this.hits = h;
        this.id = i;
        this.image = im;
        this.lastChapter = lastChapter;
        this.status = s;
        this.title = t;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    private class Category {
        String category;
    }
}
