package com.noveogroup.task1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressWarnings({"ConstantConditions", "ResourceType"})
public class ReadFragment extends Fragment {


	public ReadFragment() {

		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_read, container, false);
	}

	public String getName() {
		return ((EditText) getView().findViewById(R.id.name_input)).getText().toString();
	}

	public String getSurname() {
		return ((EditText) getView().findViewById(R.id.surname_input)).getText().toString();
	}

	public Calendar getBirthDate() {
		DatePicker datePicker = (DatePicker) getView().findViewById(R.id.birthdate_input);
		Calendar calendar = Calendar.getInstance();
		calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
		return calendar;
	}
}
