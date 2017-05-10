package com.example.cleandiplomproject.screens.home.fragments.details_fragment;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.cleandiplomproject.Injector;
import com.example.cleandiplomproject.R;
import com.example.cleandiplomproject.application.DiplomProjectApp;
import com.example.cleandiplomproject.common.ScreenNavigationManager;
import com.example.cleandiplomproject.models.PlacesData;
import com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.adapters.PlacesAdapter;
import com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.presenter.DetailsPresenter;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aiachimov on 4/26/17.
 */

public class DetailsFragment extends Fragment implements DetailsPresenter.PlacesCallBack {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.container)
    FrameLayout containerLayout;

    private PlacesData placesData;

    @Inject
    ScreenNavigationManager screenNavigationManager;
    @Inject
    PlacesAdapter placesAdapter;
    @Inject
    DetailsPresenter detailsPresenter;

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Injector.INSTANCE.getHomeComponent().inject(this);
        detailsPresenter.setUpCallback(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this,view);
        detailsPresenter.loadPlaces();
        setupRecyclerView();

        return view;
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        placesAdapter.setPlaceList(placesData.getPlacesList());
        recyclerView.setAdapter(placesAdapter);
    }

    @Override
    public void onPlacesLoaded(PlacesData placesDataCallBack) {
        placesData = placesDataCallBack;
    }

    @Override
    public void onFailedPlacesLoaded() {
        Toast.makeText(getContext(), "Failed to load", Toast.LENGTH_SHORT).show();
    }
}
