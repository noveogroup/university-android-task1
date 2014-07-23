package com.noveogroup.task1;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {
    public final static String EXTRA_FIRST_NAME = "com.noveogroup.task1.firstname";
    public final static String EXTRA_LAST_NAME = "com.noveogroup.task1.lasttname";
    public final static String EXTRA_AGE = "com.noveogroup.task1.age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();
        FragmentManager fm = getFragmentManager();
        FragmentOutput fo = (FragmentOutput) fm.findFragmentById(R.id.frag_output);
        fo.setData(i.getStringExtra(EXTRA_FIRST_NAME),i.getStringExtra(EXTRA_LAST_NAME),i.getIntExtra(EXTRA_AGE, 0));
    }
}
