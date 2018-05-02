package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        String address = getString(place.getAddressResourceId());

        TextView loc= findViewById(R.id.loc);
        loc.setText(address);

        LinearLayout location = findViewById(R.id.location);

        // here we convert the address into a geo uri so google map could identify it
        final String locationMap = "geo:0,0?q="+address;

        /** another ways to use geo
        geo:latitude,longitude?q=query
        geo:0,0?q=my+street+address
        geo:0,0?q=latitude,longitude(label)
        **/

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creates an Intent that will load a map of the selected place
                Uri uri1 = Uri.parse (locationMap);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri1);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }
}
