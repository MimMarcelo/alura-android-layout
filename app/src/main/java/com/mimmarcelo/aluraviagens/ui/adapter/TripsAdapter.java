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
    private final NumberFormat numberFormat;

    public TripsAdapter(Context context, List<Trip> trips) {
        this.context = context;
        this.trips = trips;
        this.numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
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
        int identifier = context.getResources().getIdentifier(trip.getImage(), "drawable", context.getPackageName());
        holder.image.setImageResource(identifier);

        holder.local.setText(trip.getLocal());

        String days = " days";
        if(trip.getDays() == 1){
            days = " day";
        }
        holder.days.setText(trip.getDays() + days);

        holder.price.setText(numberFormat.format(trip.getPrice()).replace("R$", "R$ "));
        return view;
    }
}
