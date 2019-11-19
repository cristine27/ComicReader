package com.example.comicreader.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.comicreader.Model.KumpulanManga;
//import com.example.comicreader.Model.Manga;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
                Log.d("TAG",response.code()+"");

                Manga resource = response.body();
                String end = resource.end;

                JsonArray mangaObj = resource.kumpulanManga;
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
}
