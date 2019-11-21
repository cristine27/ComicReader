package com.example.comicreader;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comicreader.Model.Manga;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class info_fragment extends Fragment {
    private static info_fragment info_fragment;
    private static final String BASE_URL = "https://www.mangaeden.com/api/manga/";
    private Context context;
    private ArrayList<Manga> mangaList;
    private Manga mangaClick;

    public info_fragment() {
        // Required empty public constructor
    }

    public static info_fragment createInfoScreen(Context context, ArrayList<Manga> mangaList){
        if(info_fragment==null){
            info_fragment = new info_fragment();
            info_fragment.context = context;
            info_fragment.mangaList = (ArrayList<Manga>)mangaList;
        }
        return info_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_info_fragment, container, false);
        mangaClick = null;

        return view;
    }

    public void getMangaInfo(){
        String idManga = mangaClick.getId();
        String url = BASE_URL+idManga+"/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("TEST","MASUK KLIK MANGA");
                    JSONObject obj = new JSONObject(response);
                    String deskripsi = obj.getString("description");
                    String author = obj.getString("description");

                    mangaClick.setAuthor(author);
                    mangaClick.setSummary(deskripsi);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TEST","GAGAL.. TRY AGAIN");
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(stringRequest);


    }
}
