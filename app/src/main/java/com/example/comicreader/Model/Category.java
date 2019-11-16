package com.example.comicreader.Model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("c")
    private String category;

    public Category(String category){
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
