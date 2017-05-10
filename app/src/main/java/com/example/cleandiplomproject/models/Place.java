package com.example.cleandiplomproject.models;

/**
 * Created by aiachimov on 5/2/17.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Place implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("opening_hours")
    private String openingHours;
    @SerializedName("price")
    private int price;
    @SerializedName("description")
    private String description;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lng")
    private double lng;
    @SerializedName("photo") List<String> photo;

    protected Place(Parcel in) {
        name = in.readString();
        openingHours = in.readString();
        price = in.readInt();
        description = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
        photo = in.createStringArrayList();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(final String openingHours) {
        this.openingHours = openingHours;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(final double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(final double lng) {
        this.lng = lng;
    }

    public List<String> getPhotoList() {
        return photo;
    }

    public void setPhotoList(final List<String> photo) {
        this.photo = photo;
    }

    public LatLng getLatLng() {
        return new LatLng(lat, lng);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(openingHours);
        dest.writeInt(price);
        dest.writeString(description);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeStringList(photo);
    }
}
