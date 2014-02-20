package com.nakardo.trendyhotels.dto;

/**
 * Created by nakes on 2/17/14.
 */
public class HotelCountRequest extends BaseRequest<GeoData> {
    private static final String COUNT_EVENT = "count";

    public HotelCountRequest() {
        super(COUNT_EVENT);
    }

    @Override
    public GeoData getData() {
        // TODO I should populate this data with coordinates obtained from LocationManager.
        return new GeoData(40.7142700, -74.0059700); // new york, new york.
    }
}
