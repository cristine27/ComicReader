package com.example.comicreader.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.comicreader.Model.Manga;
import com.example.comicreader.Presenter.Presenter;
import com.example.comicreader.R;

import java.util.ArrayList;

public class chapter_fragment extends Fragment {
    private static chapter_fragment chapter_fragment;
    private Presenter presenter;
    private Context context;
    private img_adapter adapter;
    private ArrayList<Manga> mangalist;
    private ArrayList<String> kumpulanImg;
    private TextView tv_chapter,tv_chapterText;
    private ListView lv_list_chapter;

    public static chapter_fragment createChapterScreen(Context context,ArrayList<Manga> mangalist, Presenter presenter){
        if(chapter_fragment == null){
            chapter_fragment = new chapter_fragment();
            chapter_fragment.context = context;
            chapter_fragment.mangalist = mangalist;
            chapter_fragment.presenter = presenter;
        }
        return chapter_fragment;
    }

    public chapter_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list_chapter, container, false);

        this.kumpulanImg = presenter.getKumpulanImg();

        this.tv_chapter = view.findViewById(R.id.tv_chapter);
        this.tv_chapterText = view.findViewById(R.id.tv_chapterText);
        this.lv_list_chapter = view.findViewById(R.id.lv_list_chapter);
        System.out.println("ukuran img " + this.kumpulanImg.size());
        this.adapter = new img_adapter(this.kumpulanImg,context);
        this.lv_list_chapter.setAdapter(this.adapter);

        return view;
    }

}