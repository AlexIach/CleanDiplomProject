package com.example.cleandiplomproject.screens.home.fragments.test_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleandiplomproject.R;

/**
 * Created by aiachimov on 4/26/17.
 */

public class TestFragment extends Fragment {

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_test, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
