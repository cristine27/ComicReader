package com.example.comicreader.Model;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Manga {
    @SerializedName("end")
    public String end;

    @SerializedName("manga")
    public JsonArray kumpulanManga = new JsonArray();

    @SerializedName("page")
    public String page;

    @SerializedName("start")
    public String start;

    @SerializedName("total")
    public String total;

    public class m {
        @SerializedName("a")
        public String alias;

        @SerializedName("c")
        public JsonObject categories= new JsonObject();

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

        private class Category {
            String category;
        }
    }
}
