package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAbove extends Fragment {
    ValueActions mCallback;
    TextView textView, textViewCount;
    ImageButton btnPlus, btnMinus;
    int count = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_above, container, false);
        textView = view.findViewById(R.id.textView15);
        textViewCount = view.findViewById(R.id.textView18);
        btnPlus = view.findViewById(R.id.imageButton2);
        btnMinus = view.findViewById(R.id.imageButton);
        textView.setText(count * 141800 + "");
        textViewCount.setText(count + "");
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) count--;
                textViewCount.setText(count + "");
                textView.setText(count * 141800 + "");
                mCallback.sendValue(count * 141800 + "");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textViewCount.setText(count + "");
                textView.setText(count * 141800 + "");
                mCallback.sendValue(count * 141800 + "");
            }
        });
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mCallback = (ValueActions) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement TextClicked");
        }
    }
    public void updateValue(int value) {
        textView.setText(value + "");
    }

    public interface ValueActions {
        public void sendValue(String value);
    }
}
