package com.example.comicreader.View;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class List_fragment extends Fragment {
    list_adapter adapter;
    ListView lvManga;
    ArrayList<Manga> mangaList;
    FragmentManager manager;
    FragmentTransaction ft;

    public List_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_fragment, container, false);
        manager = this.getActivity().getSupportFragmentManager();
        ft = manager.beginTransaction();

        return view;
    }

    public void setMangaList(ArrayList<Manga> manga){
        this.mangaList=manga;
        this.adapter = new list_adapter(manga, this.getActivity());
        this.lvManga.setAdapter(adapter);
    }

}
