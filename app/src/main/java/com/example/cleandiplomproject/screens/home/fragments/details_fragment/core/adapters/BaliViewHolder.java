package com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleandiplomproject.R;
import com.example.cleandiplomproject.common.ScreenNavigationManager;
import com.example.cleandiplomproject.models.Place;
import com.example.cleandiplomproject.screens.place.PlacesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aiachimov on 5/2/17.
 */

public class BaliViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.opening_hours)
    TextView openingHours;
    @BindView(R.id.root)
    CardView root;
    @BindView(R.id.headerImage)
    ImageView placePhoto;

    @BindView(R.id.imageClock)
    ImageView imageViewClock;
    @BindView(R.id.imagePrice)
    ImageView imageViewPrice;

    private Context context;
    private Place place;
    private AppCompatActivity appCompatActivity;
    private ScreenNavigationManager screenNavigationManager;

    @OnClick
    void onItemClick() {
        Intent i = new Intent(context, PlacesActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("PLACES_EXTRA", place);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Pair<View, String> pair1 = Pair.create((View) title, title.getTransitionName());
            Pair<View, String> pair2 = Pair.create((View) placePhoto, placePhoto.getTransitionName());
            Pair<View, String> pair3 = Pair.create((View) price, price.getTransitionName());
            Pair<View, String> pair4 = Pair.create((View) openingHours, openingHours.getTransitionName());
            Pair<View, String> pair5 = Pair.create((View) imageViewClock, imageViewClock.getTransitionName());
            Pair<View, String> pair6 = Pair.create((View) imageViewPrice, imageViewPrice.getTransitionName());


            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(appCompatActivity, pair1, pair2, pair3, pair4, pair5, pair6);
            screenNavigationManager.switchActivityWithTransition(appCompatActivity, i, optionsCompat);
        } else {
            context.startActivity(i);
            screenNavigationManager.switchActivityWithBundleIntent(context, i);
        }
    }

    public BaliViewHolder(final View itemView, AppCompatActivity appCompatActivity, ScreenNavigationManager screenNavigationManager) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = itemView.getContext();
        this.appCompatActivity = appCompatActivity;
        this.screenNavigationManager = screenNavigationManager;
    }

    public void bindView(Place place) {
        if (place != null) {
            this.place = place;
            title.setText(place.getName());
            openingHours.setText(place.getOpeningHours());
            price.setText(String.valueOf(place.getPrice()));
            placePhoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.monkey_forest_1));
        }
    }
}