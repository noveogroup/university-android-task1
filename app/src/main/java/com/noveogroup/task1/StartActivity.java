package com.noveogroup.task1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		replaceFragment(new ReadFragment());
	}

	private void replaceFragment(Fragment fragment) {
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, fragment);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}

	private Fragment getCurrentFragment() {
		return getFragmentManager().findFragmentById(R.id.fragment_container);
	}

	@SuppressWarnings("ResourceType")
	public void sendInfo(View view) {
		ReadFragment readFragment = (ReadFragment) getCurrentFragment();
		ShowFragment showFragment = ShowFragment.newInstance(readFragment.getName(), readFragment.getSurname(), readFragment.getBirthDate());
		replaceFragment(showFragment);
		//showFragment.applyInfo(readFragment.getName(), readFragment.getSurname(), readFragment.getBirthDate());
		System.out.println(getCurrentFragment());
	}

}
