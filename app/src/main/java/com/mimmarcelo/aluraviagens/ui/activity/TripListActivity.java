package com.mimmarcelo.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mimmarcelo.aluraviagens.R;
import com.mimmarcelo.aluraviagens.M;
import com.mimmarcelo.aluraviagens.dao.TripsDAO;
import com.mimmarcelo.aluraviagens.model.Trip;
import com.mimmarcelo.aluraviagens.ui.adapter.TripsAdapter;

import java.util.List;

public class TripListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        setTitle(getString(R.string.trip_list_header));

        List<Trip> trips = new TripsDAO().getAll();

        ListView ltvTrips = findViewById(R.id.ltv_trips);
        ltvTrips.setAdapter(new TripsAdapter(this, trips));
        ltvTrips.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Trip trip = (Trip) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, TripResumeActivity.class);
        intent.putExtra(M.extra.trip_obj, trip);
        startActivity(intent);
    }
}
