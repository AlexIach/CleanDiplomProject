package com.example.cleandiplomproject.application.builder;

import android.content.Context;

import com.example.cleandiplomproject.application.DiplomProjectApp;
import com.example.cleandiplomproject.common.ScreenNavigationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aiachimov on 4/26/17.
 */

@Module
public class DiplomProjectModule {

    private DiplomProjectApp cleanDiplomProject;

    public DiplomProjectModule(DiplomProjectApp cleanDiplomProject) {
        this.cleanDiplomProject = cleanDiplomProject;
    }

    @Provides
    public Context provideApplicationContext() {
        return cleanDiplomProject.getApplicationContext();
    }
}
