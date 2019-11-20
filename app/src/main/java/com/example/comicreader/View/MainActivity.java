package com.example.comicreader.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.comicreader.Model.KumpulanManga;
//import com.example.comicreader.Model.Manga;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    RecyclerView recyclerView;
    MangaAdapter adapter;
    ArrayList<Manga> arrayManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recycle View
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        adapter = new MangaAdapter(arrayManga);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        //welcome screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //web service
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<Manga> call = apiInterface.getMangaList();
        call.enqueue(new Callback<Manga>() {
            @Override
            public void onResponse(Call<Manga> call, Response<Manga> response) {
                Log.d("TAG",response.code()+"");

                Manga resource = response.body();
                String end = resource.end;

                JsonArray mangaObj = resource.kumpulanManga;
                Gson gson = new Gson();
                Manga.m manga = gson.fromJson(mangaObj,Manga.m.class);
                String page = resource.page;
                String start = resource.start;
                String total = resource.total;

                System.out.println("berhasil");
            }

            @Override
            public void onFailure(Call<Manga> call, Throwable t) {
                System.out.println("gagal");
                call.cancel();
            }
        });
    }

    public void addData(){
        //add list ke recycle view
        arrayManga = new ArrayList<>();
    }
}
