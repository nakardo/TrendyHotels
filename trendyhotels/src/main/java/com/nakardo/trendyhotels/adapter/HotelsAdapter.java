package com.nakardo.trendyhotels.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nakardo.trendyhotels.R;
import com.nakardo.trendyhotels.dto.Hotel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nakes on 2/19/14.
 */
public class HotelsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Hotel> mHotels;

    public HotelsAdapter(Context context, ArrayList<Hotel> hotels) {
        mContext = context;
        mHotels = hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        mHotels = hotels;
    }

    @Override
    public int getCount() {
        return mHotels.size();
    }

    @Override
    public Object getItem(int position) {
        return mHotels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.row_hotel, parent, false);

            holder = new ViewHolder();
            holder.hotelImage = (ImageView) view.findViewById(R.id.hotel_image);
            holder.hotelName = (TextView) view.findViewById(R.id.hotel_name);
            holder.address = (TextView) view.findViewById(R.id.hotel_address);
            holder.district = (TextView) view.findViewById(R.id.hotel_district);
            holder.count = (TextView) view.findViewById(R.id.hotel_count);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Hotel hotel = mHotels.get(position);
        holder.hotelName.setText(hotel.getHotelName());
        holder.address.setText(hotel.getAddress());
        holder.district.setText(hotel.getDistrict());
        holder.count.setText(String.valueOf(hotel.getCount()));

        Picasso.with(mContext)
                .load(hotel.getMainPhotoUrl())
                .into(holder.hotelImage);

        return view;
    }

    private static class ViewHolder {
        public ImageView hotelImage;
        public TextView hotelName;
        public TextView district;
        public TextView address;
        public TextView count;
    }
}
