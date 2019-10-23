package com.example.sanks_lab3_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout canvas;
    String[] color_list ={"White","Red", "Blue", "Green", "Black", "Cyan", "Yellow", "Magenta","Gray"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        canvas = findViewById(R.id.canvas);
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_NUMBER,0);
        canvas.setBackgroundColor(Color.parseColor(color_list[position]));
        //System.out.println(position+"<- val"+color_list[position]);
    }
}
