package com.example.krishanroy.psychic_app_hw_roy_krishan.drawables;

import android.content.Context;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawableResources {
    private List<Integer> myBoatImageList = new ArrayList<>();
    private List<Integer> myForestImageList = new ArrayList<>();
    private List<Integer> myLakeImageList = new ArrayList<>();


    private Context context;

    public DrawableResources(Context context) {
        this.context = context;
    }

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
        int boats_1 = R.drawable.boats_1;
        int boats_2 = R.drawable.boats_2;
        int boats_3 = R.drawable.boats_3;
        int boats_4 = R.drawable.boats_4;
        int forest_1 = R.drawable.forest_1;
        int forest_2 = R.drawable.forest_2;
        int forest_3 = R.drawable.forest_3;
        int forest_4 = R.drawable.forest_4;
        int lake_1 = R.drawable.lake_1;
        int lake_2 = R.drawable.lake_2;
        int lake_3 = R.drawable.lake_3;
        int lake_4 = R.drawable.lake_4;
        myBoatImageList.add(boats_1);
        myBoatImageList.add(boats_2);
        myBoatImageList.add(boats_3);
        myBoatImageList.add(boats_4);
        myForestImageList.add(forest_1);
        myForestImageList.add(forest_2);
        myForestImageList.add(forest_3);
        myForestImageList.add(forest_4);
        myLakeImageList.add(lake_1);
        myLakeImageList.add(lake_2);
        myLakeImageList.add(lake_3);
        myLakeImageList.add(lake_4);
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
