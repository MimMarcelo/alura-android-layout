package com.mimmarcelo.aluraviagens.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.model.Trip;
import com.mimmarcelo.aluraviagens.ui.activity.TripListActivity;
import com.mimmarcelo.aluraviagens.ui.holder.TripHolder;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class TripsAdapter extends BaseAdapter {
    private final Context context;
    private final List<Trip> trips;

    public TripsAdapter(Context context, List<Trip> trips) {
        this.context = context;
        this.trips = trips;
    }

    @Override
    public int getCount() {
        return trips.size();
    }

    @Override
    public Object getItem(int position) {
        return trips.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TripHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.listitem_trip, parent, false);
            holder = new TripHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (TripHolder) view.getTag();
        }
        Trip trip = trips.get(position);
        holder.image.setImageResource(trip.getImageResource(context));
        holder.local.setText(trip.getLocal());
        holder.days.setText(trip.getDaysResource());
        holder.price.setText(trip.getPriceResource());

        return view;
    }
}
