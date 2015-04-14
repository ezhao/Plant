package com.herokuapp.ezhao.plant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.herokuapp.ezhao.plant.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PlantFragment extends Fragment {
    @InjectView(R.id.ivPlant) ImageView ivPlant;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        ButterKnife.inject(this, view);
        return view;
    }
}
