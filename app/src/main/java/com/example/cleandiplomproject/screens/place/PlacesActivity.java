package com.example.cleandiplomproject.screens.place;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cleandiplomproject.R;
import com.example.cleandiplomproject.models.Place;

/**
 * Created by aiachimov on 4/25/17.
 */

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Place place = getIntent().getParcelableExtra("PLACES_EXTRA");
    }
}
