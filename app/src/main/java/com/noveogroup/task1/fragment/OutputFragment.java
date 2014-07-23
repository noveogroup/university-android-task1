package com.noveogroup.task1.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noveogroup.task1.R;

public class OutputFragment extends Fragment {
    public static final String INFORMATION = "com.noveogroup.task1.INFORMATION";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.output_layout, container, false);
        TextView textView = (TextView)view.findViewById(R.id.show_information);
        textView.setText(bundle.getString(INFORMATION));
        return view;
    }
}