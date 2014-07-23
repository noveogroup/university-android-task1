package com.noveogroup.task1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOutput extends Fragment {
    private TextView firstName;
    private TextView lastName;
    private TextView age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);
        firstName = (TextView) v.findViewById(R.id.textFirstName);
        lastName = (TextView) v.findViewById(R.id.textLastName);
        age = (TextView) v.findViewById(R.id.textAge);
        return v;
    }

    public void setData(String first, String last, int a) {
        firstName.setText(first);
        lastName.setText(last);
        age.setText(String.valueOf(a));
    }
}
