package com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cleandiplomproject.R;
import com.example.cleandiplomproject.common.ScreenNavigationManager;
import com.example.cleandiplomproject.models.Place;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by aiachimov on 5/2/17.
 */

public class PlacesAdapter extends RecyclerView.Adapter {

    AppCompatActivity appCompatActivity;
    private Context context;
    private List<Place> placeList = new ArrayList<>();
    private Place place;
    private ScreenNavigationManager screenNavigationManager;

    @Inject
    public PlacesAdapter(AppCompatActivity appCompatActivity, Context context, ScreenNavigationManager screenNavigationManager) {
        this.appCompatActivity = appCompatActivity;
        this.context = context;
        this.screenNavigationManager = screenNavigationManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaliViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bali_places, parent, false), appCompatActivity, screenNavigationManager);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        place = (Place) placeList.get(position);
        ((BaliViewHolder) holder).bindView(place);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }


    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
