package com.mimmarcelo.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mimmarcelo.aluraviagens.M;
import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.model.Trip;

import java.text.NumberFormat;
import java.util.Locale;

public class TripResumeActivity extends AppCompatActivity {

    public ImageView image;
    public TextView local;
    public TextView days;
    public TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_resume);

        this.image = findViewById(R.id.img_banner_trip);
        this.local = findViewById(R.id.txt_city_name);
        this.days = findViewById(R.id.txt_trip_days);
        this.price = findViewById(R.id.txt_trip_price);

        if(!getIntent().hasExtra(M.extra.trip_obj)){
            Toast.makeText(this, "Trip data was not send", Toast.LENGTH_LONG).show();
            finish();
        }
        Trip trip = (Trip) getIntent().getSerializableExtra(M.extra.trip_obj);

        image.setImageResource(trip.getImageResource(this));
        local.setText(trip.getLocal());
        days.setText(trip.getDaysResource());
        price.setText(trip.getPriceResource());
    }
}
