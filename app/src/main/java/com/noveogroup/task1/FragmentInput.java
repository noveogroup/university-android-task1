package com.noveogroup.task1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import java.util.Date;

public class FragmentInput extends Fragment implements View.OnClickListener {
    private EditText firstName;
    private EditText lastName;
    private DatePicker date;
    private Button showInfo;

    public interface OnClickButtonListener {
        void onClickButton(String first, String last, int age);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.showInformation) {
            OnClickButtonListener listener = (OnClickButtonListener) getActivity();
            listener.onClickButton(firstName.getText().toString(), lastName.getText().toString(), calcAge(date));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        firstName = (EditText) v.findViewById(R.id.editFirstName);
        lastName = (EditText) v.findViewById(R.id.editLastName);
        date = (DatePicker) v.findViewById(R.id.dateBirthday);
        showInfo = (Button) v.findViewById(R.id.showInformation);
        Date d = new Date();
        date.setMaxDate(d.getTime());
        showInfo.setOnClickListener(this);
        return v;
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
