package com.noveogroup.task1;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentInput.OnClickButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClickButton(String first, String last, int age) {
        FragmentManager fm = getFragmentManager();
        FragmentOutput fo = (FragmentOutput) fm.findFragmentById(R.id.frag_output);

        if(fo == null || !fo.isVisible()) {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra(SecondActivity.EXTRA_FIRST_NAME, first);
            i.putExtra(SecondActivity.EXTRA_LAST_NAME, last);
            i.putExtra(SecondActivity.EXTRA_AGE, age);
            startActivity(i);
        }
        else
            fo.setData(first,last,age);
    }
}
