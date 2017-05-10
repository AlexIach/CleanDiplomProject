package com.example.cleandiplomproject.application;

import android.app.Application;

import com.example.cleandiplomproject.Injector;

/**
 * Created by aiachimov on 4/25/17.
 */

public class DiplomProjectApp extends Application {

    private static DiplomProjectApp diplomProjectApp;

    @Override
    public void onCreate() {
        super.onCreate();
        diplomProjectApp = this;
        initDependencies();
    }

    public void initDependencies() {
        Injector.INSTANCE.initCleanDiplomProjectComponent(this);
    }

    public static DiplomProjectApp getInstance() {
        return diplomProjectApp;
    }
}
