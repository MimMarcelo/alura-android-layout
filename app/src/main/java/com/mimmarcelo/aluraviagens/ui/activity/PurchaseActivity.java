package com.mimmarcelo.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mimmarcelo.aluraviagens.M;
import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.model.Trip;

public class PurchaseActivity extends AppCompatActivity implements View.OnClickListener {

    private Trip trip;
    private TextView price;
    private Button btnPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasing);
        setTitle(R.string.header_of_payment_activity);

        getViews();
        this.trip = checkTrip();
        bindViews();
    }

    private void bindViews() {
        price.setText(trip.getPriceResource());
        btnPurchase.setOnClickListener(this);
    }

    private void getViews() {
        this.price = findViewById(R.id.txt_trip_price);
        this.btnPurchase = findViewById(R.id.btn_purchasing);
    }

    private Trip checkTrip() {
        if(!getIntent().hasExtra(M.extra.trip_obj)){
            Toast.makeText(this, "Trip data was not send", Toast.LENGTH_LONG).show();
            finish();
        }
        return (Trip) getIntent().getSerializableExtra(M.extra.trip_obj);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PurchaseResumeActivity.class);
        intent.putExtra(M.extra.trip_obj, trip);
        startActivity(intent);
        finish();
    }
}
