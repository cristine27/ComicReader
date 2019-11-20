package com.example.comicreader.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicreader.Model.Manga;
import com.example.comicreader.R;

import java.util.ArrayList;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {
    protected ArrayList<Manga> listManga;

    public MangaAdapter(ArrayList<Manga> m){
        this.listManga = m;
    }

    @Override
    public MangaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_manga, parent, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MangaViewHolder holder, int position) {
//        holder.title.setText(listManga.get(position).title);
//        holder.poster.setImageResource(Integer.parseInt(listManga.get(position).image));
//        holder.genre.setText(listManga.get(position).categories.size());
    }

    @Override
    public int getItemCount() {
        return (listManga != null) ? listManga.size() : 0;
    }

    public class MangaViewHolder extends RecyclerView.ViewHolder{
        private TextView title, genre;
        private ImageView poster;

        public MangaViewHolder(View view){
            super(view);
            this.title = view.findViewById(R.id.tv_title);
            this.genre = view.findViewById(R.id.tv_genre);
            this.poster = view.findViewById(R.id.iv_poster);
        }
    }
}
