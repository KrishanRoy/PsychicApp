package com.example.krishanroy.psychic_app_hw_roy_krishan.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.database.CountDatabase;
import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;
import com.example.krishanroy.psychic_app_hw_roy_krishan.R;

public class GuessViewHolder extends RecyclerView.ViewHolder {
    private ImageView userSelectedImageView;
    private ImageView computerSelectedImageVIew;

    public GuessViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void onBind(TrackAverage trackAverage){
        userSelectedImageView = itemView.findViewById(R.id.user_selction_imageView_in_itemview);
        computerSelectedImageVIew = itemView.findViewById(R.id.computer_selction_imageView_itemview);
        userSelectedImageView.setImageResource(trackAverage.getUserSelection());
        computerSelectedImageVIew.setImageResource(trackAverage.getComputerSelection());


    }
}
