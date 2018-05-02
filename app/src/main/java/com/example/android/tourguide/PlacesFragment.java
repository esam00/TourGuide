package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {


    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        // Create a list of places
        final List<Place> places = new ArrayList<>();
        places.add(new Place(R.string.qaitbey,R.string.historic,R.drawable.fort_qaitbey
                ,R.string.about_qaitbey,R.string.qaitbey_opening
                ,R.string.qaitbey_number,R.string.qaitbey_address));
        places.add(new Place(R.string.montazah,R.string.gardens,R.drawable.montazah
                ,R.string.about_montazah,R.string.montazah_opening
                ,R.string.montazah_number,R.string.montazah_address));
        places.add(new Place(R.string.national_museum,R.string.museums,R.drawable.national_museum
                ,R.string.about_national_museum,R.string.national_museum_opening
                ,R.string.national_museum_number,R.string.national_museum_address));
        places.add(new Place(R.string.qaitbey,R.string.historic,R.drawable.fort_qaitbey
                ,R.string.about_qaitbey,R.string.qaitbey_opening
                ,R.string.qaitbey_number,R.string.qaitbey_address));
        places.add(new Place(R.string.montazah,R.string.gardens,R.drawable.montazah
                ,R.string.about_montazah,R.string.montazah_opening
                ,R.string.montazah_number,R.string.montazah_address));
        places.add(new Place(R.string.national_museum,R.string.museums,R.drawable.national_museum
                ,R.string.about_national_museum,R.string.national_museum_opening
                ,R.string.national_museum_number,R.string.national_museum_address));
        places.add(new Place(R.string.qaitbey,R.string.historic,R.drawable.fort_qaitbey
                ,R.string.about_qaitbey,R.string.qaitbey_opening
                ,R.string.qaitbey_number,R.string.qaitbey_address));

        // Find the {@link RecyclerView} object in the view hierarchy of the {@link Activity}.
        RecyclerView recyclerView = rootView.findViewById(R.id.list);

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getContext(),places);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Make  the {@link RecycleView} use the {@link PlaceAdapter} we created above, so that the
        // {@link RecycleView} will display list items for each {@link Place} in the list.
        recyclerView.setAdapter(adapter);

        /* if you want to make a dividerline between each item in list use this :
        but we are now using a cardview so we don't need that

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                linearLayoutManager.getOrientation()
        );
        recyclerView.addItemDecoration(mDividerItemDecoration);
        */

        adapter.setOnItemClickListener(new PlaceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                // Get the {@link Word} object at the given position the user clicked on
                Place place = places.get(position);
                Intent intent = new Intent(getActivity(),PlaceInfoActivity.class);
                intent.putExtra("Place",place);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
