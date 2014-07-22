package com.noveogroup.task1.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.noveogroup.task1.R;
import com.noveogroup.task1.calculator.Calculator;
import com.noveogroup.task1.fragment.InputFragment;
import com.noveogroup.task1.fragment.OutputFragment;

public class MainActivity extends Activity implements InputFragment.OnSendListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    @Override
    public void onSend(View view) {
        Fragment outputFragment = new OutputFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        EditText name = (EditText)findViewById(R.id.enter_name);
        EditText surname = (EditText)findViewById(R.id.enter_surname);
        DatePicker datePicker = (DatePicker)findViewById(R.id.date_picker);
        String age = Integer.toString(Calculator.calculateAge(datePicker));
        TextView textView = (TextView)findViewById(R.id.show_information);
        textView.setText(getString(R.string.name) + "\n" + name + "\n"
                + getString(R.string.surname) + "\n" + surname + "\n"
                + getString(R.string.age) + "\n" + age + "\n");

        transaction.replace(R.id.input_fragment, outputFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
