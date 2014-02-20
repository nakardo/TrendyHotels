package com.nakardo.trendyhotels.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by nakes on 2/19/14.
 */
public class HotelCountResponse {
    private String mStatus;
    private ArrayList<Hotel> mResults;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public ArrayList<Hotel> getResults() {
        return mResults;
    }

    public void setResults(ArrayList<Hotel> results) {
        Collections.sort(results, new Comparator<Hotel>() {
            public int compare(Hotel o1, Hotel o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        mResults = results;
    }
}
