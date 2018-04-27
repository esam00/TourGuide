package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

/**
 * Created by Essam on 03/03/2018.
 */

public class Place implements Parcelable{
    /**
     * declaring int variables of the place details such as ( place name , place category , location
     * opening and closing time , phone number and short description of the place object
     */
    //place name
    private int  mPlaceNameResourceId ;
    // category of place (historic , museums .. )
    private int mPlaceCategoryResourceId;
    private int mImageResourceId ;
    private int mDescriptionResourceId;
    private int mOpeningResourceId;
    private int mPhoneNumberResourceId;

    /**
     * constructor
     */
    public Place(int placeName , int placeCategory, int imageResourceId,
            int descriptionResourceId, int openingResourceId ,int phoneNumberResourceId ){
       mPlaceNameResourceId = placeName;
       mPlaceCategoryResourceId = placeCategory;
       mImageResourceId = imageResourceId ;
       mDescriptionResourceId = descriptionResourceId;
       mOpeningResourceId = openingResourceId ;
       mPhoneNumberResourceId = phoneNumberResourceId;


    }
    /**
     * and those methods to get back the values of the current position object
     */
    public int getPlaceNameResourceId(){
        return mPlaceNameResourceId;
    }

    public int getPlaceCategoryResourceId(){
        return mPlaceCategoryResourceId;
    }

    public  int getDescriptionResourceId(){
        return mDescriptionResourceId;
    }
    public  int getOpeningResourceId(){
        return mOpeningResourceId;
    }
    public  int getPhoneNumberResourceId(){
        return mPhoneNumberResourceId;
    }
    public  int getImageResourceId(){
        return mImageResourceId;
    }

    //write object values to parcel for storage
    public void writeToParcel(Parcel dest, int flags){
        //write all properties to the parcel
        dest.writeInt(mPlaceNameResourceId);
        dest.writeInt(mPlaceCategoryResourceId);
        dest.writeInt(mImageResourceId);
        dest.writeInt(mDescriptionResourceId);
        dest.writeInt(mOpeningResourceId);
        dest.writeInt(mPhoneNumberResourceId);

    }

    //constructor used for parcel
    public Place(Parcel parcel){
        //read and set saved values from parcel
        mPlaceNameResourceId = parcel.readInt();
        mPlaceCategoryResourceId = parcel.readInt();
        mImageResourceId = parcel.readInt();
        mDescriptionResourceId = parcel.readInt();
        mOpeningResourceId = parcel.readInt();
        mPhoneNumberResourceId = parcel.readInt();
    }

    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>(){

        @Override
        public Place createFromParcel(Parcel parcel) {
            return new Place(parcel);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[0];
        }
    };

    //return hashcode of object
    public int describeContents() {
        return hashCode();
    }

}
