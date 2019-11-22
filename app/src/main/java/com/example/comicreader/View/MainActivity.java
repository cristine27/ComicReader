package com.example.comicreader.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

//import com.example.comicreader.Model.Manga;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.Presenter.Presenter;
import com.example.comicreader.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements InterfaceManga {
    protected List_fragment list_fragment;
    protected info_fragment info_fragment;
    protected RequestManga requestManga;
    protected FragmentManager fm;
    protected ArrayList<Manga> mangaList;
    protected Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new Presenter(this,this);
        this.mangaList = new ArrayList<>();
        this.requestManga = new RequestManga(this,this);
        this.list_fragment = List_fragment.createHomeScreen(this,this.mangaList,presenter);
        this.info_fragment = info_fragment.createInfoScreen(this,this.mangaList,presenter);
        this.fm = this.getSupportFragmentManager();
        FragmentTransaction ft =this.fm.beginTransaction();
        ft.add(R.id.frame_container, this.list_fragment).commit();
    }

    @Override
    public void getMangaid(Manga manga, int position) {
        System.out.println("create page berhasil ");
        this.info_fragment.cretePage(manga,position);
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

            if(this.info_fragment.isAdded()){
                ft.hide(this.info_fragment);
            }
        }
        else if(id==2){
            if(this.info_fragment.isAdded()){
                ft.show(this.info_fragment);
            }
            else{
                ft.add(R.id.frame_container,this.info_fragment);
            }

            if(this.list_fragment.isAdded()){
                ft.hide(this.list_fragment);
            }
        }
        ft.commit();
    }
}
