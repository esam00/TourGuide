package com.example.android.tourguide;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Essam on 03/03/2018.
 */
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    // Store a member variable for the places
    private List<Place> mPlaces;
    Context mContext;

    // Pass in the contact array into the constructor
    public PlaceAdapter(Context context, List<Place> places) {

        this.mPlaces = places;
        this.mContext = context;
    }


    /***** Creating OnItemClickListener *****/

    // Define listener member variable
    private OnItemClickListener listener;

    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Provide a direct reference to each of the views within a list item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView categoryTextView;
        public TextView openingTextView;
        public ImageView placeImage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = itemView.findViewById(R.id.place_name_text_view);
            categoryTextView = itemView.findViewById(R.id.place_category_text_view);
            placeImage = itemView.findViewById(R.id.image);
            openingTextView = itemView.findViewById(R.id.opening_time_text_view);

            // Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }


    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View placeView = inflater.inflate(R.layout.list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(placeView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Place place = mPlaces.get(position);

        // Set item views based on your views and data model
        TextView name = viewHolder.nameTextView;
        name.setText(place.getPlaceNameResourceId());

        TextView category = viewHolder.categoryTextView;
        category.setText(place.getPlaceCategoryResourceId());

        TextView opening = viewHolder.openingTextView;
        opening.setText(place.getOpeningResourceId());

        ImageView image = viewHolder.placeImage;
        image.setImageResource(place.getImageResourceId());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

}
