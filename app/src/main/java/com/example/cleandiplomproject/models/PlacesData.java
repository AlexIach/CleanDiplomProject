package com.example.cleandiplomproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aiachimov on 5/2/17.
 */

public class PlacesData {

    @SerializedName("places")
    List<Place> placesList;

    public List<Place> getPlacesList() {
        return placesList;
    }
}
