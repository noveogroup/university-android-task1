package com.noveogroup.task1.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noveogroup.task1.R;

public class InputFragment extends Fragment {
    protected OnSendListener sendListener;

    public interface OnSendListener {
        void onSend(View view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            sendListener = (OnSendListener)activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSendListener.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_layout, container, false);
    }

    public void onSendClick(View view) {
        sendListener.onSend(view);
    }

}

