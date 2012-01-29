package com.jayway.lab.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This is the secondary fragment, displaying the details of a particular
 * item.
 */
public class DetailsFragment extends Fragment {

	private OnTitleDisplayingListener mListener;
	
	private static String[] details = { "details1", "details2", "details3" };

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnTitleDisplayingListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnTitleDisplayingListener");
		}
	}

	/**
	 * Create a new instance of DetailsFragment, initialized to show the
	 * text at 'index'.
	 */
	public static DetailsFragment newInstance(int index) {
		DetailsFragment f = new DetailsFragment();

		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);
		return f;
	}

	public int getSelectedIndex() {
		return getArguments().getInt("index", 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		TextView textView = (TextView) inflater.inflate(R.layout.detail_fragment_layout,
				container, false);
		textView.setText(details[getSelectedIndex()]);

		mListener.onTitleDisplaying(getSelectedIndex());

		return textView;
	}
	
	public interface OnTitleDisplayingListener {
		public void onTitleDisplaying(int index);
	}
}