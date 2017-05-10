package com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.presenter;

import android.content.res.AssetManager;

import com.example.cleandiplomproject.application.DiplomProjectApp;
import com.example.cleandiplomproject.models.PlacesData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.inject.Inject;

/**
 * Created by aiachimov on 5/10/17.
 */

public class DetailsPresenter {

    private final static String JSON_PATH = "bali.json";
    private PlacesCallBack callback;

    @Inject
    public DetailsPresenter() {
    }

    public void setUpCallback(PlacesCallBack callback) {
        this.callback = callback;
    }

    public void loadPlaces() {
        try {
            AssetManager assetManager = DiplomProjectApp.getInstance().getAssets();
            InputStream inputStream;

            inputStream = assetManager.open(JSON_PATH);

            Gson gson = new Gson();
            Reader reader = new InputStreamReader(inputStream);

            callback.onPlacesLoaded(gson.fromJson(reader, PlacesData.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface PlacesCallBack {
        void onPlacesLoaded(PlacesData placesData);
        void onFailedPlacesLoaded();
    }
}
