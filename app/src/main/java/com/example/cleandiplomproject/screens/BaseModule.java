package com.example.cleandiplomproject.screens;

import android.support.v7.app.AppCompatActivity;

import com.example.cleandiplomproject.common.ScreenNavigationManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aiachimov on 5/2/17.
 */

@Module
public abstract class BaseModule<T extends AppCompatActivity>{

    private T appCompatActivity;

    public BaseModule(T appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    public ScreenNavigationManager provideScreenNavigationManager() {
        return new ScreenNavigationManager(appCompatActivity.getSupportFragmentManager());
    }
}
