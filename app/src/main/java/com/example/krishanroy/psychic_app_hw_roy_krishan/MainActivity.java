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

        MainFragment mainFragment = MainFragment.newInstance(-1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container_framelayout, mainFragment)
                .commit();
    }
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

    @Override
    public void moveFromChoiceToResultFragment(boolean perfectMatch, int userSelected, int computerSelected) {
        ResultFragment resultFragment = ResultFragment.newInstance(perfectMatch, userSelected, computerSelected);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container_framelayout, resultFragment)
                .addToBackStack("result")
                .commit();
    }
}
