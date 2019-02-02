package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private View rootView;


    private static final String RESULT_FRAGMENT_STRING_KEY = "result fragment string key" ;

    public ResultFragment() {
        // Required empty public constructor
    }
    public static ResultFragment newInstance(String string){
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_FRAGMENT_STRING_KEY, string);
        resultFragment.setArguments(bundle);
        return resultFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_result, container, false);
        return rootView;
    }

}
