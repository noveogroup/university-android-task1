package com.noveogroup.task1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class ShowFragment extends Fragment {

	private static final String NAME_STRING = "name";
	private static final String SURNAME_STRING = "surname";
	private static final String BIRTH_DATE_STRING = "birth_date";

	public static ShowFragment newInstance(String name, String surname, Calendar birthDate) {
		ShowFragment fragment = new ShowFragment();
		Bundle args = new Bundle();
		args.putString(NAME_STRING, name);
		args.putString(SURNAME_STRING, surname);
		args.putSerializable(BIRTH_DATE_STRING, birthDate);
		fragment.setArguments(args);
		return fragment;
	}

	@SuppressWarnings("ConstantConditions")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_show, container, false);
		applyInfo(view);
		return view;
	}


	private void applyInfo(View view) {
		TextView currentTextView = (TextView) view.findViewById(R.id.name_text);
		currentTextView.setText(getString(R.string.name_text, getArguments().getString(NAME_STRING)));
		currentTextView = (TextView) view.findViewById(R.id.surname_text);
		currentTextView.setText(getString(R.string.surname_text, getArguments().getString(SURNAME_STRING)));
		currentTextView = (TextView) view.findViewById(R.id.birthday_text);
		int age = getAge((Calendar) getArguments().getSerializable(BIRTH_DATE_STRING));
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
