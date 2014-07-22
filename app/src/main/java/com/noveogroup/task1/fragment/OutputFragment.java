package com.noveogroup.task1.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noveogroup.task1.R;

public class OutputFragment extends Fragment {
    protected OnSendAgainListener sendAgainListener;

    public interface OnSendAgainListener {
        void onSendAgain(View view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            sendAgainListener = (OnSendAgainListener)activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSendAgainListener.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.output_layout, container, false);
    }

    public void onSendAgainClick(View view) {
        sendAgainListener.onSendAgain(view);
    }



}