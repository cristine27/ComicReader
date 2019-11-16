package com.example.comicreader.View;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
}
