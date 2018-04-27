package com.example.android.tourguide;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        Intent intent = getIntent();
        Place place = intent.getParcelableExtra("Place");

        //now collect all property values
        CollapsingToolbarLayout placeName = findViewById(R.id.collapsingToolbar);
        placeName.setTitle(getString(place.getPlaceNameResourceId()));

        TextView placeCategory = findViewById(R.id.place_category);
        placeCategory.setText(place.getPlaceCategoryResourceId());

        ImageView placeImage = findViewById(R.id.place_image);
        placeImage.setImageResource(place.getImageResourceId());

        TextView description = findViewById(R.id.description);
        description.setText(place.getDescriptionResourceId());

        TextView openingTime = findViewById(R.id.opening_closing_time);
        openingTime.setText(place.getOpeningResourceId());

        TextView phoneNumber = findViewById(R.id.phone_number);
        phoneNumber.setText(place.getPhoneNumberResourceId());

    }
}
