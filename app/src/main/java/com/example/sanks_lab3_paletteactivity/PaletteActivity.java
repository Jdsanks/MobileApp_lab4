package com.example.sanks_lab3_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.sanks_lab3_paletteactivity.EXTRA_NUMBER";

    ConstraintLayout layout;
    Spinner spinner; //frag

    //Resources res = [strings.]getResources();
    //String[] gridLabels = res.getStringArray(R.array.strings);
    //String[] color_list; //{"White","Red", "Blue", "Green", "Black", "Cyan", "Yellow", "Magenta","Gray"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] color = getResources().getStringArray(R.array.color);
        String[] color_list_change = getResources().getStringArray(R.array.color_change);

        layout = findViewById(R.id.layout);
        spinner = findViewById(R.id.spinner);

        ColorAdapter adaptor = new ColorAdapter(PaletteActivity.this, color,color_list_change);
        spinner.setAdapter((adaptor));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    System.out.println("id =" + position);
                    open_canvas_activity(position);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public void open_canvas_activity(int position) {
        Intent intent = new Intent(this, CanvasActivity.class);
        intent.putExtra(EXTRA_NUMBER, position);
        startActivity(intent);
    }
}


