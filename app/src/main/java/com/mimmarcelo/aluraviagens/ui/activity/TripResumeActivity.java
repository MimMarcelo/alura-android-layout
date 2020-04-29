package com.mimmarcelo.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mimmarcelo.aluraviagens.M;
import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.model.Trip;

public class TripResumeActivity extends AppCompatActivity {

    public ImageView image;
    public TextView local;
    public TextView days;
    public TextView price;
    private TextView period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_resume);
        setTitle(R.string.header_of_resume_activity);

        getViews();
        Trip trip = checkTrip();
        bindViews(trip);
    }

    private Trip checkTrip() {
        if(!getIntent().hasExtra(M.extra.trip_obj)){
            Toast.makeText(this, "Trip data was not send", Toast.LENGTH_LONG).show();
            finish();
        }
        return (Trip) getIntent().getSerializableExtra(M.extra.trip_obj);
    }

    private void bindViews(Trip trip) {
        image.setImageResource(trip.getImageResource(this));
        local.setText(trip.getLocal());
        days.setText(trip.getDaysResource());
        price.setText(trip.getPriceResource());
        period.setText(trip.getPeriodResource());
    }

    private void getViews() {
        this.image = findViewById(R.id.img_banner_trip);
        this.local = findViewById(R.id.txt_trip_local);
        this.days = findViewById(R.id.txt_trip_days);
        this.price = findViewById(R.id.txt_trip_price);
        this.period = findViewById(R.id.txt_trip_period);
    }
}
