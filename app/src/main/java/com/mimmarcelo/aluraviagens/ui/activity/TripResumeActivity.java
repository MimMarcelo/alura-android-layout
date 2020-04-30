package com.mimmarcelo.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mimmarcelo.aluraviagens.M;
import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.model.Trip;

public class TripResumeActivity extends AppCompatActivity implements View.OnClickListener {

    private Trip trip;

    public ImageView image;
    public TextView local;
    public TextView days;
    public TextView price;
    private TextView period;
    private Button btnPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_resume);
        setTitle(R.string.header_of_resume_activity);

        getViews();
        this.trip = checkTrip();
        bindViews();
    }

    private Trip checkTrip() {
        if(!getIntent().hasExtra(M.extra.trip_obj)){
            Toast.makeText(this, "Trip data was not send", Toast.LENGTH_LONG).show();
            finish();
        }
        return (Trip) getIntent().getSerializableExtra(M.extra.trip_obj);
    }

    private void bindViews() {
        image.setImageResource(trip.getImageResource(this));
        local.setText(trip.getLocal());
        days.setText(trip.getDaysResource());
        price.setText(trip.getPriceResource());
        period.setText(trip.getPeriodResource());
        btnPayment.setOnClickListener(this);
    }

    private void getViews() {
        this.image = findViewById(R.id.img_banner_trip);
        this.local = findViewById(R.id.txt_trip_local);
        this.days = findViewById(R.id.txt_trip_days);
        this.price = findViewById(R.id.txt_trip_price);
        this.period = findViewById(R.id.txt_trip_period);
        this.btnPayment = findViewById(R.id.btn_make_payment);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(M.extra.trip_obj, trip);
        startActivity(intent);
        finish();
    }
}
