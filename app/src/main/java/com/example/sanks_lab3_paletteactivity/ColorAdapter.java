package com.example.sanks_lab3_paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    private Context c;
    private String[] color_list;
    private String[] color_list_change;


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

        String colorsEng = color_list[position];
        String colorText = color_list_change[position];

        t.setText(colorText);

        t.setBackgroundColor(Color.parseColor(colorsEng));
        return t;
    }

    public ColorAdapter(Context c, String[] color_list,String[] color_list_change ) {
        this.c = c;
        this.color_list = color_list;
        this.color_list_change = color_list_change;

    }
}