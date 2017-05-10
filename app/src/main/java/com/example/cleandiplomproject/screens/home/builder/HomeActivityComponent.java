package com.example.cleandiplomproject.screens.home.builder;

import com.example.cleandiplomproject.application.builder.DiplomProjectComponent;
import com.example.cleandiplomproject.screens.home.HomeActivity;
import com.example.cleandiplomproject.screens.home.fragments.details_fragment.DetailsFragment;

import dagger.Component;

/**
 * Created by aiachimov on 4/28/17.
 */

@ScopeHomeActivity
@Component(dependencies = DiplomProjectComponent.class, modules = {HomeActivityModule.class})
public interface HomeActivityComponent {

    void inject(HomeActivity homeActivity);
    void inject(DetailsFragment detailsFragment);
}
