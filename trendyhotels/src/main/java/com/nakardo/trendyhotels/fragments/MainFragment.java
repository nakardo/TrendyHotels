package com.nakardo.trendyhotels.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nakardo.trendyhotels.MainActivity;
import com.nakardo.trendyhotels.R;
import com.nakardo.trendyhotels.adapter.HotelsAdapter;
import com.nakardo.trendyhotels.dto.Hotel;
import com.nakardo.trendyhotels.dto.HotelCountResponse;

import java.util.ArrayList;

/**
 * Created by nakes on 2/18/14.
 */
public class MainFragment extends Fragment implements MainActivity.HotelsCountCallback {
    private static final String HOTELS_LIST_BUNDLE_KEY = "HOTELS_LIST";

    private ArrayList<Hotel> mHotels;
    private ListView mListView;
    private HotelsAdapter mListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mHotels = (ArrayList<Hotel>) savedInstanceState.getSerializable(HOTELS_LIST_BUNDLE_KEY);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(HOTELS_LIST_BUNDLE_KEY, mHotels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mListView = (ListView) rootView.findViewById(android.R.id.list);
        if (mHotels != null) {
            mListAdapter = new HotelsAdapter(getActivity(), mHotels);
            mListView.setAdapter(mListAdapter);
        }

        return rootView;
    }

    @Override
    public void onHotelsLoaded(HotelCountResponse hotels) {
        mHotels = hotels.getResults();

        if (mListAdapter == null) {
            mListAdapter = new HotelsAdapter(getActivity(), mHotels);
            mListView.setAdapter(mListAdapter);
        } else {
            mListAdapter.setHotels(mHotels);
            mListAdapter.notifyDataSetChanged();
        }
    }
}
