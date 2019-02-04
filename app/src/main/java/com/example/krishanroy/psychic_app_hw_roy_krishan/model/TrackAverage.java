package com.example.krishanroy.psychic_app_hw_roy_krishan.model;

import android.graphics.drawable.Drawable;

public class TrackAverage {
    private Drawable userSelection;
    private Drawable computerSelection;
    private int result;


    public TrackAverage(Drawable userSelection, Drawable computerSelection, int result) {
        this.userSelection = userSelection;
        this.computerSelection = computerSelection;
        this.result = result;
    }

    public Drawable getUserSelection() {
        return userSelection;
    }

    public Drawable getComputerSelection() {
        return computerSelection;
    }

    public int getResult() {
        return result;
    }
}
