package com.noveogroup.task1.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.noveogroup.task1.R;
import com.noveogroup.task1.calculator.Calculator;

import java.util.Date;

public class InputFragment extends Fragment {
    private OnSendListener onSendListener;

    public interface OnSendListener {
        void onSend(String name, String surname, String age);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof OnSendListener)) {
            throw new RuntimeException(activity.toString()
                    + " must implement OnSendListener.");
        }
        onSendListener = (OnSendListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_layout, container, false);
        Button sendButton = (Button)view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText)getActivity()
                               .findViewById(R.id.enter_name)).getText().toString();
                String surname = ((EditText)getActivity()
                                  .findViewById(R.id.enter_surname)).getText().toString();
                DatePicker datePicker = (DatePicker)getActivity().findViewById(R.id.date_picker);
                String age = Integer.toString(Calculator.calculateAge(
                        datePicker.getYear(), datePicker.getMonth(),
                        datePicker.getDayOfMonth()));

                onSendListener.onSend(name, surname, age);
            }
        });
        ((DatePicker) view.findViewById(R.id.date_picker)).setMaxDate(new Date().getTime());
        return view;
    }
}

