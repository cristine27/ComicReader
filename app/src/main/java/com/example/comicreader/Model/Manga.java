package com.example.comicreader.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Manga {
    @SerializedName("a")
    public String alias;

    @SerializedName("c")
    public ArrayList<Category> categories;

    @SerializedName("h")
    public int hits;

    @SerializedName("i")
    public String id;

    @SerializedName("im")
    public String image;

    @SerializedName("s")
    public String status;

    @SerializedName("t")
    public String title;

    public Manga(String a, ArrayList<Category> c, int h, String i, String im, String s, String t){
        this.alias=a;
        this.categories=c;
        this.hits=h;
        this.id=i;
        this.image=im;
        this.status=s;
        this.title=t;
    }

    public String getAlias() {
        return alias;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public int getHits() {
        return hits;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
