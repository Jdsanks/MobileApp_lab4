package com.example.sanks_lab3_paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context c;
    String color_list[];

    @Override
    public int getCount() {
        return color_list.length;
    }

    @Override
    public Object getItem(int position) { return color_list[position]; }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView t = new TextView(c);
        t.setText(color_list[position]);
        t.setBackgroundColor(Color.parseColor(color_list[position]));
        return t;
    }

    public ColorAdapter(Context c, String[] color_list) {
        this.c = c;
        this.color_list = color_list;
    }
}