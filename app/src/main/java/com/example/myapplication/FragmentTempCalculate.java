package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTempCalculate extends Fragment {
    TextView textViewPrice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp_calculate, container, false);
        textViewPrice = view.findViewById(R.id.tvPrice);
        return view;
    }

    public void updatePrice(String content) {
        textViewPrice.setText(content);
    }
}
