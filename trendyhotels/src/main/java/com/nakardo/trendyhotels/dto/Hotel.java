package com.nakardo.trendyhotels.dto;

import java.io.Serializable;

/**
 * Created by nakes on 2/19/14.
 */
public class Hotel implements Serializable {
    private String mHotelName;
    private String mDistrict;
    private String mAddress;
    private String mMainPhotoUrl;
    private String mUrl;
    private int mCount;

    public String getHotelName() {
        return mHotelName;
    }

    public void setHotelName(String hotelName) {
        this.mHotelName = hotelName;
    }

    public String getDistrict() {
        return mDistrict;
    }

    public void setDistrict(String district) {
        this.mDistrict = district;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public String getMainPhotoUrl() {
        return mMainPhotoUrl;
    }

    public void setMainPhotoUrl(String mMainPhotoUrl) {
        this.mMainPhotoUrl = mMainPhotoUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}
