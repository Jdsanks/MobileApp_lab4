package com.example.sanks_lab3_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {
    ConstraintLayout layout;
    Spinner spinner;
    String[] color_list = {"Red", "Blue", "Green", "Black", "Cyan", "Yellow", "White", "Magenta",
            "Gray"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        spinner = findViewById(R.id.spinner);

        ColorAdapter adaptor = new ColorAdapter( PaletteActivity.this,color_list);
        spinner.setAdapter((adaptor));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                layout.setBackgroundColor(Color.parseColor(color_list[position]));
                view.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setBackgroundColor(Color.WHITE);
            }
        });

    }}

