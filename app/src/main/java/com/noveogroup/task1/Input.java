package com.noveogroup.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;


public class Input extends Activity {
    private Button showInfo;
    private EditText firstName;
    private EditText lastName;
    private DatePicker birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        showInfo = (Button) findViewById(R.id.showInformation);
        firstName = (EditText) findViewById(R.id.editFirstName);
        lastName = (EditText) findViewById(R.id.editLastName);
        birthday = (DatePicker) findViewById(R.id.dateBirthday);

        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Input.this , Show.class);
                i.putExtra(Show.EXTRA_FIRST_NAME, firstName.getText().toString());
                i.putExtra(Show.EXTRA_LAST_NAME, lastName.getText().toString());
                int age = calcAge(birthday);
                i.putExtra(Show.EXTRA_AGE, age);
                startActivity(i);
            }
        });
    }

    private int calcAge(final DatePicker d) {
        Calendar c = Calendar.getInstance();
        int age = c.get(Calendar.YEAR) - d.getYear();
        if(d.getMonth() < c.get(Calendar.MONTH))
            age--;
        else if(d.getMonth() == c.get(Calendar.MONTH) && d.getDayOfMonth() > c.get(Calendar.DAY_OF_MONTH))
            age--;
        return age;
    }
}
