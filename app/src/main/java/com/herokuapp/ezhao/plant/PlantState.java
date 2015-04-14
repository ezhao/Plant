package com.herokuapp.ezhao.plant;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("PlantState")
public class PlantState extends ParseObject {
    public enum State {
        HAPPY, WILTING, WILTED
    }

    public enum Action {
        WATER, RESET
    }

    public PlantState() {
        super();
    }

    public PlantState(State endState, Action action) {
        super();
        setEndState(endState);
        setAction(action);
    }

    public State getEndState() {
        String endState = getString("end_state");
        switch (endState) {
            case "WILTING":
                return State.WILTING;
            case "WILTED":
                return State.WILTED;
            default:
                return State.HAPPY;
        }
    }

    public void setEndState(State endState) {
        switch (endState) {
            case WILTING:
                put("end_state", "WILTING");
                break;
            case WILTED:
                put("end_state", "WILTED");
                break;
            default:
                put("end_state", "HAPPY");
                break;
        }
    }

    public Action getAction() {
        String action = getString("action");
        switch (action) {
            case "WATER":
                return Action.WATER;
            default:
                return Action.RESET;
        }
    }

    public void setAction(Action action) {
        switch (action) {
            case WATER:
                put("action", "WATER");
                break;
            default:
                put("action", "RESET");
                break;
        }
    }
}
