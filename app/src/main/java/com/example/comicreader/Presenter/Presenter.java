package com.example.comicreader.Presenter;

import android.content.Context;

import com.example.comicreader.Model.Manga;
import com.example.comicreader.View.InterfaceManga;

public class Presenter {
    private InterfaceManga interfaceManga;
    private Context context;

    public Presenter(InterfaceManga interfaceManga, Context context){
        this.interfaceManga = interfaceManga;
        this.context = context;
    }

    public void sendMangaInfo(Manga mangaClick,int position){
        this.interfaceManga.getMangaid(mangaClick,position);
    }

    public void changePage(int id){
        this.interfaceManga.changePage(id);
    }
}
