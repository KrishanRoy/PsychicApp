package com.example.krishanroy.psychic_app_hw_roy_krishan.model;

public class TrackAverage {
    private int numberOfTrial;
    private int numberOfSuccess;

    public TrackAverage(int numberOfTrial, int numberOfSuccess) {
        this.numberOfTrial = numberOfTrial;
        this.numberOfSuccess = numberOfSuccess;

    }
    public int getNumberOfTrial() {
        return numberOfTrial;
    }

    public int getNumberOfSuccess() {
        return numberOfSuccess;
    }

}
