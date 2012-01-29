package com.jayway.lab.fragments;

import com.jayway.lab.fragments.DetailsFragment.OnTitleDisplayingListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Demonstration of using fragments to implement different activity layouts.
 * This sample provides a different layout (and activity flow) when run in
 * landscape.
 */
public class MainActivity extends FragmentActivity implements
		OnTitleDisplayingListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onTitleDisplaying(int index) {
		TitlesFragment titles = (TitlesFragment) getSupportFragmentManager()
				.findFragmentById(R.id.titles);
		if (titles != null) {
			titles.getListView().setItemChecked(index, true);
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		DetailsFragment details = (DetailsFragment) getSupportFragmentManager()
				.findFragmentById(R.id.details);

		// If the details fragment is not displayed, the back button should
		// close the application.
		if (details == null || !details.isVisible()) {
			finish();
		}
	}
}