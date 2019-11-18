package com.example.comicreader.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.example.comicreader.Model.Category;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;

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
                Log.d("Tag",response.code()+"");

                String displayResponse = "";

                Manga manga = response.body();

                String alias = manga.alias;
                int hitz = manga.hits;
                String id = manga.id;
                String image = manga.image;
                ArrayList<Category> category = manga.categories;
                String status = manga.status;
                String title = manga.title;

                System.out.println();
            }

            @Override
            public void onFailure(Call<Manga> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public void addData(){
        //add list ke recycle view
        arrayManga = new ArrayList<>();
    }
}
