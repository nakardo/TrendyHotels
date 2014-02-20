package com.nakardo.trendyhotels;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import com.nakardo.trendyhotels.dto.HotelCountResponse;
import com.nakardo.trendyhotels.fragments.MainFragment;
import com.nakardo.trendyhotels.fragments.WorkerFragment;

public class MainActivity extends ActionBarActivity implements WorkerFragment.WorkerCallback {
    private static final String WORKER_FRAGMENT_TAG = "WORKER_FRAGMENT";
    private static final String LIST_FRAGMENT_TAG = "LIST_FRAGMENT";

    private WorkerFragment mWorkerFragment;

    public static interface HotelsCountCallback {
        public void onHotelsLoaded(HotelCountResponse hotels);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        mWorkerFragment = (WorkerFragment) fm.findFragmentByTag(WORKER_FRAGMENT_TAG);

        // If the Fragment is non-null, then it is currently being
        // retained across a configuration change.
        if (mWorkerFragment == null) {
            mWorkerFragment = new WorkerFragment();
            fm.beginTransaction()
                    .add(mWorkerFragment, WORKER_FRAGMENT_TAG)
                    .commit();
        }

        if (savedInstanceState == null) {
            fm.beginTransaction()
                    .replace(R.id.container, new MainFragment(), LIST_FRAGMENT_TAG)
                    .commit();
        }
    }

    @Override
    public void onResponse(HotelCountResponse response) {
        MainFragment fragment = (MainFragment) getSupportFragmentManager()
                .findFragmentByTag(LIST_FRAGMENT_TAG);

        fragment.onHotelsLoaded(response);
    }
}
