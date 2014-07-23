package com.noveogroup.task1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.noveogroup.task1.calculator.Calculator;
import com.noveogroup.task1.R;

public class InputActivity extends Activity{
    public final static String EXTRA_NAME = "com.noveogroup.task1.NMA";
    public final static String EXTRA_SURNAME = "com.noveogroup.task1.SURNAME";
    public final static String EXTRA_AGE = "com.noveogroup.task1.AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);
        Button sendButton = (Button)findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSend();
            }
        });
    }

    public void onSend() {
        Intent intent = new Intent(this, OutputActivity.class);
        EditText name = (EditText)findViewById(R.id.enter_name);
        EditText surname = (EditText)findViewById(R.id.enter_surname);
        DatePicker datePicker = (DatePicker)findViewById(R.id.date_picker);
        intent.putExtra(EXTRA_NAME, name.getText().toString());
        intent.putExtra(EXTRA_SURNAME, surname.getText().toString());
        intent.putExtra(EXTRA_AGE, Integer.toString(Calculator.calculateAge(datePicker)));
        startActivity(intent);
    }
}
