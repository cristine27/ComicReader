package com.example.comicreader.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;

import java.util.ArrayList;

public class list_adapter extends BaseAdapter {
    ArrayList<Manga> manga = new ArrayList<>();
    Context context;

    public list_adapter(ArrayList<Manga> m, Context context){
        this.manga = m;
        this.context=context;
    }

    @Override
    public int getCount() {
        return manga.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.manga_row, null, true);

        TextView title = view.findViewById(R.id.tv_titleText);
        TextView status = view.findViewById(R.id.tv_statusText);
        ImageView poster = view.findViewById(R.id.poster);

        ArrayList<String> categori = new ArrayList<>();
        Manga mangaList = this.manga.get(i);

        title.setText(mangaList.getTitle());
        status.setText(mangaList.getStatus());
        if(mangaList.getImage().equals("null")){
            Glide.with(context).load(R.drawable.noimage).into(poster);
        }
        else{
            Glide.with(context).load("https://cdn.mangaeden.com/mangasimg/200x/"+mangaList.getImage()).into(poster);
        }
        return view;
    }
}
