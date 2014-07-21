package com.noveogroup.task1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		Resources resources = getResources();
		Intent intent = getIntent();
		TextView currentTextView = (TextView) findViewById(R.id.name_text);
		currentTextView.setText(String.format(resources.getString(R.string.name_text), intent.getStringExtra("Name")));
		currentTextView = (TextView) findViewById(R.id.surname_text);
		currentTextView.setText(String.format(resources.getString(R.string.surname_text), intent.getStringExtra("Surname")));
		currentTextView = (TextView) findViewById(R.id.birthday_text);
		currentTextView.setText(String.format(resources.getString(R.string.birthdate_text), intent.getStringExtra("Date")));
	}
}
