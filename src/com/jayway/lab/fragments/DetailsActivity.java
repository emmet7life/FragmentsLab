package com.jayway.lab.fragments;

import com.jayway.lab.fragments.DetailsFragment.OnTitleDisplayingListener;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


/**
 * This is a secondary activity, to show what the user has selected when the
 * screen is not large enough to show it all in one activity.
 */
public class DetailsActivity extends FragmentActivity implements
		OnTitleDisplayingListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// If the screen is now in landscape mode, we can show the
			// dialog in-line with the list so we don't need this activity.
			finish();
			return;
		}

		if (savedInstanceState == null) {
			// During initial setup, plug in the details fragment.
			DetailsFragment details = DetailsFragment
					.newInstance(getIntent().getExtras().getInt("index"));
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.add(android.R.id.content, details);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}
	}

	@Override
	public void onTitleDisplaying(int index) {
		// TODO Auto-generated method stub
	}
}