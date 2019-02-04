package com.example.krishanroy.psychic_app_hw_roy_krishan.drawables;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawableResources {
    private List<Drawable> myImageList = new ArrayList<>();
    private Context context;

    public DrawableResources(Context context) {
        this.context = context;
    }

    public List<Drawable> getMyImageList() {
        saveImagestoList();
        return myImageList;
    }

    public void saveImagestoList() {
        Drawable boats_1 = context.getResources().getDrawable(R.drawable.boats_1);
        Drawable boats_2 = context.getResources().getDrawable(R.drawable.boats_2);
        Drawable boats_3 = context.getResources().getDrawable(R.drawable.boats_3);
        Drawable boats_4 = context.getResources().getDrawable(R.drawable.boats_4);
        Drawable forest_1 = context.getResources().getDrawable(R.drawable.forest_1);
        Drawable forest_2 = context.getResources().getDrawable(R.drawable.forest_2);
        Drawable forest_3 = context.getResources().getDrawable(R.drawable.forest_3);
        Drawable forest_4 = context.getResources().getDrawable(R.drawable.forest_4);
        Drawable lake_1 = context.getResources().getDrawable(R.drawable.lake_1);
        Drawable lake_2 = context.getResources().getDrawable(R.drawable.lake_2);
        Drawable lake_3 = context.getResources().getDrawable(R.drawable.lake_3);
        Drawable lake_4 = context.getResources().getDrawable(R.drawable.lake_4);


        myImageList.add(boats_1);
        myImageList.add(boats_2);
        myImageList.add(boats_3);
        myImageList.add(boats_4);

        myImageList.add(forest_1);
        myImageList.add(forest_2);
        myImageList.add(forest_3);
        myImageList.add(forest_4);

        myImageList.add(lake_1);
        myImageList.add(lake_2);
        myImageList.add(lake_3);
        myImageList.add(lake_4);
    }

    public boolean perfectMatch(Drawable a, Drawable b) {
        return a == b;
    }

    public Drawable computerSelected() {
        Random random = new Random();
        return getMyImageList().get(random.nextInt(getMyImageList().size()));
    }
}
