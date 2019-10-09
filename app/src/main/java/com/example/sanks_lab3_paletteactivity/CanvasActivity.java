package com.example.sanks_lab3_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout canvas;
    String[] color_list = {"Red", "Blue", "Green", "Black", "Cyan", "Yellow", "White", "Magenta",
            "Gray"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        canvas = findViewById(R.id.canvas);
        Intent intent = getIntent();
        int position = intent.getIntExtra(PaletteActivity.EXTRA_NUMBER,0);
        canvas.setBackgroundColor(Color.parseColor(color_list[position-1]));
        //System.out.println(position+"<- val"+color_list[position]);
    }
}
