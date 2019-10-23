package com.example.sanks_lab3_paletteactivity;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.net.InterfaceAddress;


/**
 * A simple {@link Fragment} subclass.
 */
public class palette_fragment extends Fragment {




private palette_listener listener;

    public palette_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.palette_fragment, container, false);
        Context context = getActivity();
        Resources res = context.getResources();

        String[] color = getResources().getStringArray(R.array.color);
        String[] color_list_change = getResources().getStringArray(R.array.color_change);

        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);


        ColorAdapter adapter = new ColorAdapter(context, color, color_list_change);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                System.out.println("color = "+ color);
                listener.p_listener(color);          }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
        return view;

}
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof palette_listener) {
            listener = (palette_listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " forgot to implement listener");
        }
    }
    @Override
    public void onDetach(){
super.onDetach();
listener = null;
    }

}
