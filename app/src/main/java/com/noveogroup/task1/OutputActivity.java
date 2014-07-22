package com.noveogroup.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

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
        showInformation.setText(getString(R.string.name) + "\n" + name + "\n"
                                + getString(R.string.surname) + "\n" + surname + "\n"
                                + getString(R.string.age) + "\n" + age + "\n");
    }

    public void sendAgain(View view) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }
}
