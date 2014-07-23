package com.noveogroup.task1.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.noveogroup.task1.R;
import com.noveogroup.task1.fragment.InputFragment;
import com.noveogroup.task1.fragment.OutputFragment;

public class MainActivity extends Activity implements InputFragment.OnSendListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        if(savedInstanceState != null) {
            return;
        }

        InputFragment fragment = new InputFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.main_layout, fragment);
        transaction.commit();
    }

    @Override
    public void onSend(String name, String surname, String age) {
        Fragment outputFragment = new OutputFragment();
        Bundle bundle = new Bundle();
        bundle.putString(OutputFragment.INFORMATION,
                         String.format("%s\n%s\n%s\n%s\n%s\n%s\n",
                                       getString(R.string.name), name,
                                       getString(R.string.surname), surname,
                                       getString(R.string.age), age));
        outputFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_layout, outputFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
