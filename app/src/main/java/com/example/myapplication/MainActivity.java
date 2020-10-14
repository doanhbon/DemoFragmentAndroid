package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements  FragmentNotification.ValueActions {
    FrameLayout frameAbove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameAbove = findViewById(R.id.frm_above);

        FragmentAbove fragmentAbove = new FragmentAbove();
        FragmentNotification fragmentNotification = new FragmentNotification();

        getSupportFragmentManager().beginTransaction().add(R.id.frm_above, fragmentAbove).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frm_notification, fragmentNotification).commit();
    }

    @Override
    public int sendValue(int value) {
        FragmentAbove fragmentAbove = (FragmentAbove) getSupportFragmentManager().findFragmentById(R.id.frm_above);
        fragmentAbove.updateValue(value);
        return value;
    }
}