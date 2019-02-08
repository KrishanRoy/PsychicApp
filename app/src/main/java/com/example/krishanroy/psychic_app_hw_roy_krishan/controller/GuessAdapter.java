package com.example.krishanroy.psychic_app_hw_roy_krishan.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;
import com.example.krishanroy.psychic_app_hw_roy_krishan.database.CountDatabase;
import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;
import com.example.krishanroy.psychic_app_hw_roy_krishan.view.GuessViewHolder;

import java.util.List;

public class GuessAdapter extends RecyclerView.Adapter<GuessViewHolder> {
    private List<TrackAverage> trackAverageList;

    public GuessAdapter(List<TrackAverage> trackAverageList) {
        this.trackAverageList = trackAverageList;
    }

    @NonNull
    @Override
    public GuessViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.guess_item_view, viewGroup, false);
        return new GuessViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull GuessViewHolder guessViewHolder, int i) {
        guessViewHolder.onBind(trackAverageList.get(i));

    }

    @Override
    public int getItemCount() {
        return trackAverageList.size();
    }
}
