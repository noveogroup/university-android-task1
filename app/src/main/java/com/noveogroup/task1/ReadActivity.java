package com.noveogroup.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ReadActivity extends Activity {

	public static final String NAME_STRING = "Name";
	public static final String SURNAME_STRING = "Surname";
	public static final String BIRTHDATE_STRING = "Date";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
	}

	@SuppressWarnings("ResourceType")
	public void sendInfo(View view) {
		Intent intent = new Intent(this, ShowActivity.class);
		intent.putExtra(NAME_STRING, ((EditText) findViewById(R.id.name_input)).getText().toString());
		intent.putExtra(SURNAME_STRING, ((EditText) findViewById(R.id.surname_input)).getText().toString());
		DatePicker datePicker = (DatePicker) findViewById(R.id.birthdate_input);
		Calendar calendar = Calendar.getInstance();
		calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
		intent.putExtra(BIRTHDATE_STRING, calendar);
		startActivity(intent);
	}
}
