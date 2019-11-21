package com.example.comicreader.View;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class List_fragment extends Fragment implements AdapterView.OnItemClickListener {
    FragmentManager manager;
    FragmentTransaction ft;
//    RequestManga requestManga;
    private static List_fragment listFragment;
    private Context context;
    private ListView lvManga;
    private static final String JSON_URL = "https://www.mangaeden.com/api/list/0/";
    private ArrayList<Manga> mangaList;

    public List_fragment() {
        // Required empty public constructor
    }

    public static List_fragment createHomeScreen(Context context, ArrayList<Manga> mangaList){
        if(listFragment==null){
            listFragment = new List_fragment();
            listFragment.context = context;
            listFragment.mangaList = (ArrayList<Manga>) mangaList.clone();
        }
        return listFragment;
    }

//    public static List_fragment newInstance(String title,RequestManga requestManga){
//        List_fragment list = new List_fragment();
//        Bundle args = new Bundle();
//        args.putString("title",title);
//        list.setRequestManga(requestManga);
//        return list;
//    }

//    public void setRequestManga(RequestManga req){
//        this.requestManga = req;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_fragment, container, false);

        this.lvManga = view.findViewById(R.id.my_list);
        this.getMangaList();

        this.lvManga.setOnItemClickListener(this);

        return view;
    }


    public void getMangaList() {
        final ArrayList<Manga> mangaList = new ArrayList();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d("TEST", "MASUK");
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray mangalist = obj.getJSONArray("manga");

                            for (int i = 0; i < mangalist.length(); i++) {

                                JSONObject mangaReader = mangalist.getJSONObject(i);


                                Manga manga = new Manga(mangaReader.getString("i"),
                                        mangaReader.getString("t"),
                                        mangaReader.getString("a"),
                                        mangaReader.getString("c"),
                                        mangaReader.getString("s"),
                                        mangaReader.getString("h"),
                                        mangaReader.getString("im"));
                                Log.d("TEST PRINT", manga.getTitle().toString());
                                mangaList.add(manga);
                            }

                            list_adapter adapter = new list_adapter(mangaList,context);
                            lvManga.setAdapter(adapter);
//                            sendList(mangaList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TEST", "GAGAL.. TRY AGAIN BOSS");
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Manga mangaKlik = this.mangaList.get(position);
        String BASE_URL = "https://www.mangaeden.com/api/manga/";
        String idManga = mangaKlik.getId();
        String url = BASE_URL+idManga+"/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("TEST","MASUK KLIK MANGA");
                    JSONObject obj = new JSONObject(response);
                    String deskripsi = obj.getString("description");
                    String author = obj.getString("description");

                    mangaKlik.setAuthor(author);
                    mangaKlik.setSummary(deskripsi);
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
