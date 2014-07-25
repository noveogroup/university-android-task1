package com.noveogroup.task1;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentInput.OnClickButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.scrollView, new FragmentInput())
                .commit();
    }

    @Override
    public void onClickButton(String first, String last, int age) {
        FragmentManager fm = getFragmentManager();
        FragmentOutput fo = (FragmentOutput) fm.findFragmentById(R.id.frag_output);

        if(fo == null || !fo.isVisible()) {
            Bundle bundle = new Bundle();
            bundle.putString(FragmentOutput.EXTRA_NAME, first);
            bundle.putString(FragmentOutput.EXTRA_SURNAME, last);
            bundle.putInt(FragmentOutput.EXTRA_AGE, age);
            fo = new FragmentOutput();
            fo.setArguments(bundle);

            fm.beginTransaction()
                    .replace(R.id.scrollView, fo)
                    .addToBackStack(null)
                    .commit();
        }
        else {
            fo.setData(first, last, age);
        }
    }
}
