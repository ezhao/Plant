package com.herokuapp.ezhao.plant;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.herokuapp.ezhao.plant.fragments.PlantFragment;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import bolts.Task;
import butterknife.InjectView;


public class PlantActivity extends ActionBarActivity {
    FragmentManager fm;
    PlantFragment plantFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        plantFragment = new PlantFragment();
        ft.replace(R.id.flFragment, plantFragment);
        ft.commit();

        ParseQuery<PlantState> parseQuery = new ParseQuery<>(PlantState.class);
        parseQuery.orderByDescending("createdAt");
        parseQuery.getFirstInBackground(new GetCallback<PlantState>() {
            @Override
            public void done(PlantState plantState, ParseException e) {
                if (plantState != null) {
                    // Nabbed plant state from server!
                    plantFragment.setPlantState(plantState.getEndState());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_plant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            if (plantFragment != null) {
                plantFragment.setPlantState(PlantState.State.WILTED);

                PlantState parsePlantState = new PlantState(PlantState.State.WILTED, PlantState.Action.RESET);
                parsePlantState.saveEventually();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
