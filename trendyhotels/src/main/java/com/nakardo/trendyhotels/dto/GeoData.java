package com.nakardo.trendyhotels.dto;

/**
 * Created by nakes on 2/17/14.
 */
public class GeoData {
    private double mLatitude;
    private double mLongitude;

    public GeoData(double latitude, double longitude) {
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }
}
