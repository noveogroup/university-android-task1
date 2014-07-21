package com.noveogroup.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class ReadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
	}

	public void sendInfo(View view) {
		Intent intent = new Intent(this, ShowActivity.class);
		intent.putExtra("Name", ((EditText) findViewById(R.id.name_input)).getText().toString());
		intent.putExtra("Surname", ((EditText) findViewById(R.id.surname_input)).getText().toString());
		DatePicker date = (DatePicker) findViewById(R.id.birthdate_input);
		intent.putExtra("Date", date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear());
		startActivity(intent);
	}
}
