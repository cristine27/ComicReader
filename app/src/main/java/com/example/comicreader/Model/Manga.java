package com.example.comicreader.Model;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Manga {

    public ArrayList<String> categories;

    public String hits;

    public String id;

    public String image;

    public String status;

    public String title;

    public String alias;

    public Date last_chapter;

    public Manga(String title, String status, String hits, String id, String image, String alias,ArrayList<String> categories,Date last_chapter){
        this.title = title;
        if(status.equals("0")){
            this.status = "Suspended";
        }
        else if(this.status.equals("1")){
            this.status = "OnGoing";
        }
        else if(this.status.equals("2")){
            this.status = "Complete";
        }

        this.id = id;
        this.hits = hits;
        this.alias = alias;
        this.image = image;
        this.categories = categories;
        this.last_chapter = last_chapter;
}
}

