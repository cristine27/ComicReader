package com.example.comicreader.View;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.Presenter.Presenter;
import com.example.comicreader.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class info_fragment extends Fragment {
    private static info_fragment info_fragment;
    private static final String BASE_URL = "https://www.mangaeden.com/api/manga/";
    private Presenter presenter;
    private Context context;
    private ArrayList<Manga> mangaList;
    private Manga mangaClick;
    ImageView poster;
    TextView title;
    TextView description;
    TextView chapter_length;

    public info_fragment() {
        // Required empty public constructor
    }

    public static info_fragment createInfoScreen(Context context, ArrayList<Manga> mangaList, Presenter presenter){
        if(info_fragment==null){
            info_fragment = new info_fragment();
            info_fragment.context = context;
            info_fragment.mangaList = (ArrayList<Manga>)mangaList;
            info_fragment.presenter = presenter;
        }
        return info_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_info_fragment, container, false);
        this.poster = view.findViewById(R.id.iv_posterInfo);
        this.title = view.findViewById(R.id.tv_infotitletext);
        this.description = view.findViewById(R.id.tv_descinfotext);
        this.chapter_length = view.findViewById(R.id.tv_chapterinfotext);

        return view;
    }

    public void cretePage(Manga manga,int position){
        mangaClick = manga;
        System.out.println("isi manga " + manga.getTitle());
        if(!manga.getImage().equals("null")){
            Glide.with(this).load("https://cdn.mangaeden.com/mangasimg/200x/" + manga.getImage()).into(poster);
        }
        else{
            poster.setImageResource(R.drawable.noimage);
        }

        title.setText(manga.getTitle());
        description.setText(manga.getSummary());
        chapter_length.setText(manga.getChapter_length());
    }
}
