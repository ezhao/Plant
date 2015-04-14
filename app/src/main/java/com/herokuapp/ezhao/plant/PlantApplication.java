package com.herokuapp.ezhao.plant;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class PlantApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(PlantState.class);
        Parse.initialize(this, "wSBlk6aFY0sP44QAtxH3tgbpZJjsVf9IG8HynmBt", "GjAT15Zsj5eaJeKNap401k8c0tN8BQua9UtDGh0l");
    }
}
