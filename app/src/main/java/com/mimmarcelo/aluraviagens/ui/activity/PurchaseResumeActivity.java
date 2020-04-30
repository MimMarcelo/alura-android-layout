package com.mimmarcelo.aluraviagens.ui.activity;

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

public class PurchaseResumeActivity extends AppCompatActivity implements View.OnClickListener {

    private Trip trip;

    public ImageView image;
    public TextView local;
    public TextView price;
    private TextView period;
    private Button btnBackToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_resume);
        setTitle(getString(R.string.header_of_purchase_resume_activity));

        this.trip = checkTrip();
        getViews();
        bindViews();
    }

    private void bindViews() {
        image.setImageResource(trip.getImageResource(this));
        local.setText(trip.getLocal());
        price.setText(trip.getPriceResource());
        period.setText(trip.getPeriodResource());
        btnBackToList.setOnClickListener(this);
    }

    private Trip checkTrip() {
        if(!getIntent().hasExtra(M.extra.trip_obj)){
            Toast.makeText(this, "Trip data was not send", Toast.LENGTH_LONG).show();
            finish();
        }
        return (Trip) getIntent().getSerializableExtra(M.extra.trip_obj);
    }

    private void getViews() {
        this.image = findViewById(R.id.img_banner_trip);
        this.local = findViewById(R.id.txt_trip_local);
        this.price = findViewById(R.id.txt_trip_price);
        this.period = findViewById(R.id.txt_trip_period);
        this.btnBackToList = findViewById(R.id.btn_back_to_list);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(this, TripListActivity.class);
//        startActivity(intent);
        finish();
    }
}
