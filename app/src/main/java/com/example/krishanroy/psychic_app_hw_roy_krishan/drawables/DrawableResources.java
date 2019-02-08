package com.example.krishanroy.psychic_app_hw_roy_krishan.drawables;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawableResources {
    private List<Integer> myBoatImageList = new ArrayList<>();
    private List<Integer> myForestImageList = new ArrayList<>();
    private List<Integer> myLakeImageList = new ArrayList<>();

    @NonNull public static DrawableResources getDrawableResources() {
        return new DrawableResources();
    }

    private DrawableResources() { }

    public List<Integer> getMyBoatImageList() {
        saveImagestoList();
        return myBoatImageList;
    }

    public List<Integer> getMyForestImageList() {
        saveImagestoList();
        return myForestImageList;
    }

    public List<Integer> getMyLakeImageList() {
        saveImagestoList();
        return myLakeImageList;
    }

    public void saveImagestoList() {
        myBoatImageList.add(R.drawable.boats_1);
        myBoatImageList.add(R.drawable.boats_2);
        myBoatImageList.add(R.drawable.boats_3);
        myBoatImageList.add(R.drawable.boats_4);
        myForestImageList.add(R.drawable.forest_1);
        myForestImageList.add(R.drawable.forest_2);
        myForestImageList.add(R.drawable.forest_3);
        myForestImageList.add(R.drawable.forest_4);
        myLakeImageList.add(R.drawable.lake_1);
        myLakeImageList.add(R.drawable.lake_2);
        myLakeImageList.add(R.drawable.lake_3);
        myLakeImageList.add(R.drawable.lake_4);
    }

    public boolean perfectMatch(int a, int b) {
        return a == b;
    }

    public int computerBoatSelected() {
        Random random = new Random();
        return getMyBoatImageList().get(random.nextInt(4));
    }

    public int computerForestSelected() {
        Random random = new Random();
        return getMyForestImageList().get(random.nextInt(4));
    }

    public int computerLakeSelected() {
        Random random = new Random();
        return getMyLakeImageList().get(random.nextInt(4));
    }
}
