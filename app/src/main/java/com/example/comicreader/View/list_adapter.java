package com.example.comicreader.View;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.example.comicreader.Model.Manga;

import java.util.ArrayList;

public class list_adapter extends BaseAdapter {
    ArrayList<Manga> manga = new ArrayList<>();

    public list_adapter(ArrayList<Manga> m){
        this.manga = m;
    }

    @Override
    public int getCount() {
        return 0;
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

        return null;
    }
}
