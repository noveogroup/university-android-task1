package com.noveogroup.task1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.noveogroup.task1.R;

public class OutputActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_layout);

        Intent intent = getIntent();
        String name = intent.getStringExtra(InputActivity.EXTRA_NAME);
        String surname = intent.getStringExtra(InputActivity.EXTRA_SURNAME);
        String age = intent.getStringExtra(InputActivity.EXTRA_AGE);

        TextView showInformation = (TextView)findViewById(R.id.show_information);
        showInformation.setText(getString(R.string.information, name, surname, age));
    }
}
