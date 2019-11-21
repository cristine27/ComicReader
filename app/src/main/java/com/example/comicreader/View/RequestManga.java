package com.example.comicreader.View;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comicreader.Model.Manga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class RequestManga {
    protected final String BASE_URL = "https://www.mangaeden.com/api/";
    private Context context;
    ArrayList<Manga> mangaList = new ArrayList<>();

    public RequestManga(Context context) {
        this.context = context;
        getMangaList();
    }

    public void getMangaList() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray mangalist = obj.getJSONArray("manga");

                            for (int i = 0; i < mangalist.length(); i++) {

                                JSONObject mangaReader = mangalist.getJSONObject(i);


                                Manga manga = new Manga(mangaReader.getString("t"),
                                        mangaReader.getString("s"),
                                        mangaReader.getString("h"),
                                        mangaReader.getString("i"),
                                        mangaReader.getString("im"),
                                        mangaReader.getString("a"),
                                        mangaReader.getString("ld"));

                                mangaList.add(manga);
                            }

                            list_adapter adapter = new list_adapter(mangaList, context);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("error");
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(stringRequest);

    }



//    public void getMangaInfo(String id){
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = BASE_URL+"manga/"+id;
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject mangaJSON = response;
//                    if(mangaJSON.has("image") && mang)
//                    String img = mangaJSON.getString("image");
//                    String title = mangaJSON.getString()
//                }
//            }
//        })
//    }
}
