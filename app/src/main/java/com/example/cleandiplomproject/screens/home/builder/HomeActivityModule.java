package com.example.cleandiplomproject.screens.home.builder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.cleandiplomproject.common.ScreenNavigationManager;
import com.example.cleandiplomproject.screens.BaseModule;
import com.example.cleandiplomproject.screens.home.HomeActivity;
import com.example.cleandiplomproject.screens.home.core.adapters.HomePagerAdapter;
import com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.adapters.PlacesAdapter;
import com.example.cleandiplomproject.screens.home.fragments.details_fragment.core.presenter.DetailsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aiachimov on 4/28/17.
 */

@Module
public class HomeActivityModule extends BaseModule<HomeActivity> {

    private HomeActivity homeActivityPager;

    public HomeActivityModule(HomeActivity homeActivity) {
        super(homeActivity);
        this.homeActivityPager = homeActivity;

    }

    @Provides
    @ScopeHomeActivity
    public HomePagerAdapter provideHomePagerAdapter() {
        return new HomePagerAdapter(homeActivityPager.getSupportFragmentManager(), homeActivityPager.getApplicationContext(), 5);
    }

    @Provides
    @ScopeHomeActivity
    public PlacesAdapter providePlacesAdapter(Context context, ScreenNavigationManager screenNavigationManager) {
        return new PlacesAdapter(homeActivityPager, context, screenNavigationManager);
    }

    @Provides
    @ScopeHomeActivity
    public DetailsPresenter provideDEtailsPresenter(){
        return new DetailsPresenter();
    }
}
