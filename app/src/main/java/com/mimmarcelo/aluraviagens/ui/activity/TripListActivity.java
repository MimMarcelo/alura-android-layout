package com.mimmarcelo.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.dao.TripsDAO;
import com.mimmarcelo.aluraviagens.model.Trip;
import com.mimmarcelo.aluraviagens.ui.adapter.TripsAdapter;

import java.util.List;

public class TripListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        setTitle(getString(R.string.trip_list_header));

        ListView ltvTrips = findViewById(R.id.ltv_trips);
        List<Trip> trips = new TripsDAO().getAll();


        ltvTrips.setAdapter(new TripsAdapter(this, trips));
    }
}
