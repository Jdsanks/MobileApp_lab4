package com.example.sanks_lab3_paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements palette_listener {
    public static final String EXTRA_NUMBER = "com.example.sanks_lab3_paletteactivity.EXTRA_NUMBER";
    FragmentTransaction transaction;
    ConstraintLayout layout;
    Fragment p_fragment;
    Fragment c_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p_fragment = new palette_fragment(); // create fragment
        c_fragment = new canvas_fragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container_palette, p_fragment);
        transaction.add(R.id.fragment_container_canvas,c_fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void setColor(String c) {
        System.out.println("color = "+c);
    }/*
        if(findViewById(R.id.layout) != null){
            FragmentManager fm3 = getFragmentManager();
            fm3.beginTransaction();
                    transaction.replace(R.id.fragment_container, p_fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
            fm3.executePendingTransactions();
            findViewById(R.id.fragment_container).setBackgroundColor(Color.parseColor(c));
    }
}*/

    @Override
    public void p_listener(String color) {
        FrameLayout layout = findViewById(R.id.c_layout);
        layout.setBackgroundColor(Color.parseColor(color));
    }
}


