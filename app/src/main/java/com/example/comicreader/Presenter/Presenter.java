package com.example.comicreader.Presenter;

import android.content.Context;

import com.example.comicreader.Model.Chapter;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.View.InterfaceManga;

import java.util.ArrayList;

public class Presenter {
    private InterfaceManga interfaceManga;
    private Context context;
    private Manga manga;
    private int position;
    private ArrayList<Chapter> chap;
    private ArrayList<String> kumpulanImg;
    private String chapter_numb;

    public Presenter(InterfaceManga interfaceManga, Context context){
        this.interfaceManga = interfaceManga;
        this.context = context;
        this.chap = new ArrayList<>();
        this.kumpulanImg = new ArrayList<>();
        this.chapter_numb = "";
    }

    public void sendMangaInfo(){
        System.out.println("Send berhasil");
//        this.interfaceManga.getMangaid(manga,position);
    }

    public void changePage(int id){
        this.interfaceManga.changePage(id);
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Manga getManga() {
        return manga;
    }

    public int getPosition() {
        return position;
    }

    public void setChap(ArrayList<Chapter> chap) {
        this.chap = chap;
    }

    public ArrayList<Chapter> getChap() {
        return chap;
    }

    public ArrayList<String> getKumpulanImg() {
        return kumpulanImg;
    }

    public void setKumpulanImg(ArrayList<String> kumpulanImg) {
        this.kumpulanImg = kumpulanImg;
    }

    public void setChapter_numb(String chapter_numb) {
        this.chapter_numb = chapter_numb;
    }

    public String getChapter_numb() {
        return chapter_numb;
    }
}
