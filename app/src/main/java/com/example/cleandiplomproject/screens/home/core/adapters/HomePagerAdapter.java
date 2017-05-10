package com.example.cleandiplomproject.screens.home.core.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.cleandiplomproject.screens.home.fragments.details_fragment.DetailsFragment;
import com.example.cleandiplomproject.screens.home.fragments.home_fragment.HomeFragment;
import com.example.cleandiplomproject.screens.home.fragments.test_fragment.TestFragment;

/**
 * Created by aiachimov on 4/26/17.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private static final int MAIN_FRAGMENT = 0;
    private static final int MAPS_FRAGMENT = 1;
    private static final int OTHER_FRAGMENT_1 = 2;
    private static final int OTHER_FRAGMENT_2 = 3;
    private static final int OTHER_FRAGMENT_3 = 4;

    private Context context;
    int numberOfFragments;

    public HomePagerAdapter(FragmentManager fm, Context context, int numberOfFragments) {
        super(fm);
        this.context = context;
        this.numberOfFragments = numberOfFragments;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MAIN_FRAGMENT:
                return HomeFragment.newInstance();
            case MAPS_FRAGMENT:
                return DetailsFragment.newInstance();
            case OTHER_FRAGMENT_1:
                return TestFragment.newInstance();
            case OTHER_FRAGMENT_2:
                return HomeFragment.newInstance();
            case OTHER_FRAGMENT_3:
                return DetailsFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfFragments;
    }
}
