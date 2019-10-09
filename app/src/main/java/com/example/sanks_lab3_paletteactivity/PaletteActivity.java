package com.example.sanks_lab3_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.sanks_lab3_paletteactivity.EXTRA_NUMBER";

    ConstraintLayout layout;
    Spinner spinner;
    String[] color_list = {"White","Red", "Blue", "Green", "Black", "Cyan", "Yellow", "Magenta",
            "Gray"};
            boolean clicked = false;
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
                if(position!=0){
                    System.out.println("id ="+position);
                    open_canvas_activity(position);
                }
                //layout.setBackgroundColor(Color.parseColor(color_list[position]));
                //view.setBackgroundColor(Color.WHITE);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public void open_canvas_activity(int position){
        Intent intent = new Intent(this, CanvasActivity.class);
        intent.putExtra(EXTRA_NUMBER,position);
        startActivity(intent);
    }
}


