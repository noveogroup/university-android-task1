package com.noveogroup.task1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Show extends Activity {
    public final static String EXTRA_FIRST_NAME = "com.noveogroup.task1.firstname";
    public final static String EXTRA_LAST_NAME = "com.noveogroup.task1.lasttname";
    public final static String EXTRA_AGE = "com.noveogroup.task1.age";
    private TextView firstName;
    private TextView lastName;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        firstName = (TextView) findViewById(R.id.textFirstName);
        lastName = (TextView) findViewById(R.id.textLastName);
        age = (TextView) findViewById(R.id.textAge);
        setInfo();
    }

    private void setInfo() {
        firstName.setText(getIntent().getStringExtra(EXTRA_FIRST_NAME));
        lastName.setText(getIntent().getStringExtra(EXTRA_LAST_NAME));
        age.setText(String.valueOf(getIntent().getIntExtra(EXTRA_AGE,0)));
    }
}
