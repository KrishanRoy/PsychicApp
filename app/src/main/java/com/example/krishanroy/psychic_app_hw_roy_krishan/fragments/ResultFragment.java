package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;

import static com.example.krishanroy.psychic_app_hw_roy_krishan.fragments.MainFragment.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private View rootView;
    private boolean result;
    private TextView textView;


    private static final String RESULT_FRAGMENT_BOOLEAN_KEY = "result fragment string key";

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(boolean perfectMatch) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(RESULT_FRAGMENT_BOOLEAN_KEY, perfectMatch);
        resultFragment.setArguments(bundle);
        return resultFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getBoolean(RESULT_FRAGMENT_BOOLEAN_KEY);
            Log.d(TAG, "result: " + result);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_result, container, false);
        textView = rootView.findViewById(R.id.result_fragment_result_textview);
        if (result) {
            textView.setText(getString(R.string.correct_answer));
        } else {
            textView.setText(getString(R.string.wrong_try_again));
        }
        return rootView;
    }

}
