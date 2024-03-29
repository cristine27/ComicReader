package com.example.comicreader.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.example.comicreader.Model.Manga;
import com.example.comicreader.Presenter.Presenter;
import com.example.comicreader.R;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements InterfaceManga {
    protected List_fragment list_fragment;
    protected info_fragment info_fragment;
    protected chapter_fragment chapter_fragment;
    protected FragmentManager fm;
    protected ArrayList<Manga> mangaList;
    protected Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new Presenter(this,this);
        this.mangaList = new ArrayList<>();

        this.list_fragment = List_fragment.createHomeScreen(this,this.mangaList,presenter);


        this.fm = this.getSupportFragmentManager();
        FragmentTransaction ft =this.fm.beginTransaction();
        ft.add(R.id.frame_container, this.list_fragment).commit();
    }

    @Override
    public void changePage(int id) {
        FragmentTransaction ft = this.fm.beginTransaction();

        if(id==1){
            if(this.list_fragment.isAdded()){
                ft.show(this.list_fragment);
            }
            else{
                ft.add(R.id.frame_container,this.list_fragment);
            }

            if(this.info_fragment != null){
                this.info_fragment = null;
            }
        }
        else if(id==2){
            if(this.info_fragment == null){
                this.info_fragment = info_fragment.createInfoScreen(this,this.mangaList,presenter);
                ft.add(R.id.frame_container,this.info_fragment);
            }

            if(this.info_fragment != null){
                ft.show(this.info_fragment);
            }

            if(this.list_fragment.isAdded()){
                ft.hide(this.list_fragment);
            }

            if(this.chapter_fragment != null){
                ft.remove(this.chapter_fragment);
                this.chapter_fragment = null;
            }

        }
        else if(id==3){
            if(this.chapter_fragment == null){
                this.chapter_fragment = chapter_fragment.createChapterScreen(this,this.mangaList,presenter);
            }

            ft.add(R.id.frame_container,this.chapter_fragment);


            if(this.info_fragment.isAdded()){
                ft.hide(this.info_fragment);
            }

        }
        ft.commit();
    }
}
