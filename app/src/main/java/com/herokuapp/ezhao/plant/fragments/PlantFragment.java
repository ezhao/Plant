package com.herokuapp.ezhao.plant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.herokuapp.ezhao.plant.PlantState;
import com.herokuapp.ezhao.plant.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PlantFragment extends Fragment {
    @InjectView(R.id.ivPlant) ImageView ivPlant;
    @InjectView(R.id.btnWater) Button btnWater;
    private PlantState.State plantState;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        ButterKnife.inject(this, view);
        setPlantState(PlantState.State.HAPPY);
        return view;
    }

    @OnClick(R.id.btnWater)
    public void clickWater(View view) {
        switch (plantState) {
            case WILTED:
                setPlantState(PlantState.State.WILTING);
                break;
            default:
                setPlantState(PlantState.State.HAPPY);
                break;
        }
    }

    public void setPlantState(PlantState.State newPlantState) {
        switch (newPlantState) {
            case WILTING:
                ivPlant.setImageResource(R.drawable.plant_wilting);
                plantState = PlantState.State.WILTING;
                btnWater.setEnabled(true);
                break;
            case WILTED:
                ivPlant.setImageResource(R.drawable.plant_wilted);
                plantState = PlantState.State.WILTED;
                btnWater.setEnabled(true);
                break;
            default:
                ivPlant.setImageResource(R.drawable.plant_happy);
                plantState = PlantState.State.HAPPY;
                btnWater.setEnabled(false);
                break;
        }
    }
}
