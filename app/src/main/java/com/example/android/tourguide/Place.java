package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

/**
 * Created by Essam on 03/03/2018.
 */

public class Place implements Parcelable{
    /**
     * declaring int variables to receive resource ids of the place details such as ( place name , place category , location
     * opening and closing time , phone number and short description of the place object
     */
    //place name
    private int  mPlaceNameResourceId ;
    // place category (historic , museums .. )
    private int mPlaceCategoryResourceId;
    //place photo
    private int mImageResourceId ;
    //short description
    private int mDescriptionResourceId;
    //opening and closing time
    private int mOpeningResourceId;
    // phone number
    private int mPhoneNumberResourceId;
    //location address
    private int mAddressResourceId;


    /**
     * constructor
     */
    public Place(int placeName , int placeCategory, int imageResourceId,
            int descriptionResourceId, int openingResourceId ,int phoneNumberResourceId
            ,int addressResourceId ){
       mPlaceNameResourceId = placeName;
       mPlaceCategoryResourceId = placeCategory;
       mImageResourceId = imageResourceId ;
       mDescriptionResourceId = descriptionResourceId;
       mOpeningResourceId = openingResourceId ;
       mPhoneNumberResourceId = phoneNumberResourceId;
       mAddressResourceId = addressResourceId ;

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
    public  int getAddressResourceId(){
        return mAddressResourceId;
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
        dest.writeInt(mAddressResourceId);

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
        mAddressResourceId = parcel.readInt();

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
