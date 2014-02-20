package com.nakardo.trendyhotels.dto;

/**
 * Created by nakes on 2/17/14.
 */
public abstract class BaseRequest<T> {
    private String mEvent;

    public BaseRequest(String event) {
        mEvent = event;
    }

    public String getEvent() {
        return mEvent;
    }

    public abstract T getData();
}
