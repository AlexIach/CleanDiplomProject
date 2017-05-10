package com.example.cleandiplomproject.application.builder;

import android.content.Context;

import dagger.Component;

/**
 * Created by aiachimov on 4/26/17.
 */

@DiplomProjectScope
@Component(modules = {DiplomProjectModule.class})
public interface DiplomProjectComponent {

    Context context();

}
