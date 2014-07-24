package com.noveogroup.task1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class ShowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		Resources resources = getResources();
		Intent intent = getIntent();
		TextView currentTextView = (TextView) findViewById(R.id.name_text);
		currentTextView.setText(getString(R.string.name_text, intent.getStringExtra(ReadActivity.NAME_STRING)));
		currentTextView = (TextView) findViewById(R.id.surname_text);
		currentTextView.setText(getString(R.string.surname_text, intent.getStringExtra(ReadActivity.SURNAME_STRING)));
		currentTextView = (TextView) findViewById(R.id.birthday_text);
		int age = getAge((Calendar) intent.getSerializableExtra(ReadActivity.BIRTHDATE_STRING));
		if (age < 0) {
			currentTextView.setText(getString(R.string.not_born));
		} else {
			currentTextView.setText(getString(R.string.age_text, age));
		}

	}

	private int getAge(Calendar birthDate) {
		Calendar now = Calendar.getInstance();
		int result = now.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
		if (now.get(Calendar.DAY_OF_YEAR) <= birthDate.get(Calendar.DAY_OF_MONTH)) {
			--result;
		}
		return result;
	}
}
