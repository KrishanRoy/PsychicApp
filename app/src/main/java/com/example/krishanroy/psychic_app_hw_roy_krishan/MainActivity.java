package com.example.krishanroy.psychic_app_hw_roy_krishan;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.krishanroy.psychic_app_hw_roy_krishan.fragments.ChoiceFragment;
import com.example.krishanroy.psychic_app_hw_roy_krishan.fragments.FragmentInteractionInterface;
import com.example.krishanroy.psychic_app_hw_roy_krishan.fragments.MainFragment;
import com.example.krishanroy.psychic_app_hw_roy_krishan.fragments.ResultFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements FragmentInteractionInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting int position from the Main Fragment spinner to the
        // Main Activity so that even if the fragment is destroyed,
        // the user spinner selection is saved. The Choice Fragment
        // will get the position and show images based on that

        MainFragment mainFragment = MainFragment.newInstance(-1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container_framelayout, mainFragment)
                .commit();
    }
    //getting int imageSelected from the Choice Fragment and now will
    // compare with the computer selected image.

    @Override
    public void moveFromMainToChoiceFragment(int imageSelected) {
        ChoiceFragment choiceFragment = ChoiceFragment.newInstance(imageSelected);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container_framelayout, choiceFragment)
                .addToBackStack("choice")
                .commit();
    }

    /*
    the method parameter and the Fragment instance parameter
     does need to be the same. the method will be called inside
     a fragment to save a particular type of data to be carried
     over to the next fragment and the next fragment will get
     it by using getArguments.getSomething(key) call.
     That fragment does not need to save the same kind of data.
     */
    @Override
    public void moveFromChoiceToResultFragment(boolean perfectMatch) {
        ResultFragment resultFragment = ResultFragment.newInstance(perfectMatch);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container_framelayout, resultFragment)
                .addToBackStack("result")
                .commit();
    }
}
