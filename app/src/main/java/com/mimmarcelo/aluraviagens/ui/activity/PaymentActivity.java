package com.mimmarcelo.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mimmarcelo.aluraviagens.M;
import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.model.Trip;

public class PaymentActivity extends AppCompatActivity {

    private Trip trip;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(R.string.header_of_payment_activity);

        getViews();
        this.trip = checkTrip();
        bindViews();
    }

    private void bindViews() {
        price.setText(trip.getPriceResource());
    }

    private void getViews() {
        this.price = findViewById(R.id.txt_trip_price);
    }

    private Trip checkTrip() {
        if(!getIntent().hasExtra(M.extra.trip_obj)){
            Toast.makeText(this, "Trip data was not send", Toast.LENGTH_LONG).show();
            finish();
        }
        return (Trip) getIntent().getSerializableExtra(M.extra.trip_obj);
    }

}
