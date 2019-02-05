package com.example.krishanroy.psychic_app_hw_roy_krishan.model;

import android.graphics.drawable.Drawable;

public class TrackAverage {
    private int userSelection;
    private int computerSelection;
    private int result;


    public TrackAverage(int userSelection, int computerSelection, int result) {
        this.userSelection = userSelection;
        this.computerSelection = computerSelection;
        this.result = result;
    }

    public int getUserSelection() {
        return userSelection;
    }

    public int getComputerSelection() {
        return computerSelection;
    }

    public int getResult() {
        return result;
    }
}
