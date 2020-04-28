package com.mimmarcelo.aluraviagens.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mimmarcelo.aluraviagens.R;

public class TripHolder {
    public final ImageView image;
    public final TextView local;
    public final TextView days;
    public final TextView price;

    public TripHolder(View view) {
        this.image = view.findViewById(R.id.img_banner_trip);
        this.local = view.findViewById(R.id.txt_city_trip);
        this.days = view.findViewById(R.id.txt_trip_days);
        this.price = view.findViewById(R.id.txt_trip_price);
    }
}
