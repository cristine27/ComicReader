package com.example.comicreader.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KumpulanManga {
    public ArrayList<Manga> kumpulanManga;

    public KumpulanManga(){
        kumpulanManga = new ArrayList<>();
    }

    public void addManga(Manga m){
        this.kumpulanManga.add(m);
    }
}
