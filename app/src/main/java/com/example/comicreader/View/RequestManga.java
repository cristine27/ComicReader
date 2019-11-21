package com.example.comicreader.View;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
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
        RequestQueue queue = Volley.newRequestQueue(context);
        final String url = BASE_URL + "list/0";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("ini apa ? " + response.isNull(url));
                try {
                    JSONArray arrayManga = response.getJSONArray("manga");
                    for(int i = 0 ; i<arrayManga.length(); i++){
                        JSONObject mangaJSON = arrayManga.getJSONObject(i);
                        String img = mangaJSON.getString("im");
                        String title = mangaJSON.getString("t");
                        String id = mangaJSON.getString("i");
                        String alias = mangaJSON.getString("a");
                        String status = mangaJSON.getString("s");
                        String hits = mangaJSON.getString("h");
                        Date last_chapter_date = null;
                        if(mangaJSON.has("ld") && mangaJSON.getString("ld")!= null && !mangaJSON.getString("ld").equals("null")) {
                            double tempdate = Double.parseDouble(mangaJSON.getString("ld"));
                            long date = (long)tempdate;
                            last_chapter_date = new Date(date*1000);
                        }

//                        JSONArray category = new JSONArray("c");
//                        ArrayList<String> categories = new ArrayList<>();
//                        for (int j = 0; j < category.length(); j++) {
//                            categories.add(category.get(j).toString());
//                        }

                        Manga manga = new Manga(title,status,hits,id,img,alias,last_chapter_date);
                        mangaList.add(manga);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR","");
            }
        });
        queue.add(jsonObjectRequest);

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
