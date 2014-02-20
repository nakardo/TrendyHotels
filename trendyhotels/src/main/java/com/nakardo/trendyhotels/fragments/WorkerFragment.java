package com.nakardo.trendyhotels.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.nkzawa.engineio.client.Socket;
import com.nakardo.trendyhotels.Settings;
import com.nakardo.trendyhotels.dto.DefaultMapper;
import com.nakardo.trendyhotels.dto.HotelCountRequest;
import com.nakardo.trendyhotels.dto.HotelCountResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by nakes on 2/19/14.
 */
public class WorkerFragment extends Fragment {
    private WorkerCallback mCallback;
    private WebSocketClient mSocketClient;

    public static interface WorkerCallback {
        public void onResponse(HotelCountResponse response);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        try {
            URI uri = new URI("ws", null, Settings.SOCKET_SERVER_URL, Settings.SOCKET_SERVER_PORT, null, null, null);
            mSocketClient = new WebSocketClient(uri);
            mSocketClient.open();
        } catch (URISyntaxException ignored) {}
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof WorkerCallback)) {
            throw new RuntimeException("Activity must implement WorkerCallback interface.");
        }
        mCallback = (WorkerCallback) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    private class WebSocketClient extends Socket {

        public WebSocketClient(URI uri) {
            super(uri);
        }

        @Override
        public void onopen() {
            String message = null;
            try {
                message = new DefaultMapper().writeValueAsString(new HotelCountRequest());
            } catch (IOException ignored) {}

            send(message);
        }

        /*
         *  http://www.androiddesignpatterns.com/2013/04/retaining-objects-across-config-changes.html
         */
        @Override
        public void onmessage(String s) {
            try {
                final HotelCountResponse hotels = new DefaultMapper().readValue(s, HotelCountResponse.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCallback.onResponse(hotels);
                    }
                });
            } catch (IOException ignored) {}
        }

        @Override
        public void onclose() {}

        @Override
        public void onerror(Exception e) {}
    }
}
