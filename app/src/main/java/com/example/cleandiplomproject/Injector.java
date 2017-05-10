package com.example.cleandiplomproject;

import com.example.cleandiplomproject.application.DiplomProjectApp;
import com.example.cleandiplomproject.application.builder.DaggerDiplomProjectComponent;
import com.example.cleandiplomproject.application.builder.DiplomProjectComponent;
import com.example.cleandiplomproject.application.builder.DiplomProjectModule;
import com.example.cleandiplomproject.screens.home.HomeActivity;
import com.example.cleandiplomproject.screens.home.builder.DaggerHomeActivityComponent;
import com.example.cleandiplomproject.screens.home.builder.HomeActivityComponent;
import com.example.cleandiplomproject.screens.home.builder.HomeActivityModule;

/**
 * Created by aiachimov on 4/26/17.
 */

public enum Injector {

    INSTANCE;

    DiplomProjectComponent diplomProjectComponent;
    HomeActivityComponent homeActivityComponent;


    public HomeActivityComponent getHomeComponent() {
        return homeActivityComponent;
    }

    public void initCleanDiplomProjectComponent(DiplomProjectApp cleanDiplomProject) {
        if (diplomProjectComponent == null) {
            diplomProjectComponent = DaggerDiplomProjectComponent.builder()
                    .diplomProjectModule(new DiplomProjectModule(cleanDiplomProject))
                    .build();
        }
    }

    public void initHomeComponent(HomeActivity homeActivity) {
        if (homeActivityComponent == null) {
            homeActivityComponent = DaggerHomeActivityComponent.builder()
                    .homeActivityModule(new HomeActivityModule(homeActivity))
                    .diplomProjectComponent(diplomProjectComponent)
                    .build();
        }
    }

}
