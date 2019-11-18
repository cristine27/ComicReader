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
                System.out.println(response.body());
                Manga resource = response.body();
                resource.setAlias(resource.alias);
                System.out.println("tes alias "+resource.alias);
                Manga newManga = new Manga(resource.alias,resource.categories,resource.hits,resource.id,resource.image,resource.lastChapter,
                resource.status,resource.title);
                List<Manga> mangalist = new ArrayList<>();
                mangalist.add(newManga);
                System.out.println(mangalist.size());
            }

            @Override
            public void onFailure(Call<Manga> call, Throwable t) {
                call.cancel();
            }

//            @Override
//            public void onResponse(Call<KumpulanManga> call, Response<KumpulanManga> response) {
//                Log.d("TAG",response.code()+"");
//
//                KumpulanManga resource = response.body();
//                System.out.println(resource.end);
//                Integer end = resource.end;
//                List<Manga> mangaList = resource.kumpulanManga;
//                Integer page = resource.page;
//                Integer start = resource.start;
//                Integer total = resource.total;
//            }
//
//            @Override
//            public void onFailure(Call<KumpulanManga> call, Throwable t) {
//                call.cancel();
//            }
        });
    }
}
