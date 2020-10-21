package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements  FragmentAbove.ValueActions {
    FrameLayout frameAbove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameAbove = findViewById(R.id.frm_above);

        FragmentAbove fragmentAbove = new FragmentAbove();
        FragmentNotification fragmentNotification = new FragmentNotification();
        FragmentTempCalculate fragmentTempCalculate = new FragmentTempCalculate();

        getSupportFragmentManager().beginTransaction().add(R.id.frm_above, fragmentAbove).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frm_notification, fragmentNotification).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frm_temp_calculate, fragmentTempCalculate).commit();
    }

    @Override
    public void sendValue(String value) {
        FragmentTempCalculate fragmentTempCalculate = (FragmentTempCalculate) getSupportFragmentManager().findFragmentById(R.id.frm_temp_calculate);
        fragmentTempCalculate.updatePrice(value);
    }
}