package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;
import com.example.krishanroy.psychic_app_hw_roy_krishan.controller.GuessAdapter;
import com.example.krishanroy.psychic_app_hw_roy_krishan.database.CountDatabase;


public class RecyclerViewFragment extends Fragment {
    private View rootView;
    private TextView textView;


    public RecyclerViewFragment() {
    }

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        final CountDatabase countDatabase = CountDatabase.getInstance(rootView.getContext());
                RecyclerView recyclerView = rootView.findViewById(R.id.images_recycler_view);
                recyclerView.setAdapter(new GuessAdapter(countDatabase.getInputNotesList()));
                recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        return rootView;
    }


}
