package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;
import com.example.krishanroy.psychic_app_hw_roy_krishan.database.CountDatabase;

import java.io.Serializable;

public class ResultFragment extends Fragment implements Serializable {
    private View rootView;
    private boolean result;
    private TextView resultTextView;
    private TextView progressTextView;
    private TextView showAllGuesses;
    private ImageView computerSelectedImageView;
    private ImageView userSelectedImageView;
    CountDatabase countDatabase;
    private int computerSelected;
    private int userSelected;
    private FragmentInteractionInterface listener;


    private static final String RESULT_FRAGMENT_BOOLEAN_KEY = "result fragment string key";
    private static final String RESULT_FRAGMENT_COMPUTER_SELECTED_KEY = "result fragment computer string key";
    private static final String RESULT_FRAGMENT_USER_SELECTED_KEY = "result fragment user string key";


    public ResultFragment() {
    }

    public static ResultFragment newInstance(boolean perfectMatch, int userSelected, int computerSelected) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(RESULT_FRAGMENT_BOOLEAN_KEY, perfectMatch);
        bundle.putInt(RESULT_FRAGMENT_USER_SELECTED_KEY, userSelected);
        bundle.putInt(RESULT_FRAGMENT_COMPUTER_SELECTED_KEY, computerSelected);
        resultFragment.setArguments(bundle);
        return resultFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getBoolean(RESULT_FRAGMENT_BOOLEAN_KEY);
            userSelected = getArguments().getInt(RESULT_FRAGMENT_USER_SELECTED_KEY);
            computerSelected = getArguments().getInt(RESULT_FRAGMENT_COMPUTER_SELECTED_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_result, container, false);

        resultTextView = rootView.findViewById(R.id.result_fragment_result_textview);
        progressTextView = rootView.findViewById(R.id.result_fragment_progress_textview);
        computerSelectedImageView = rootView.findViewById(R.id.computer_selection_imageView);
        userSelectedImageView = rootView.findViewById(R.id.user_selected_imageView2);
        showAllGuesses = rootView.findViewById(R.id.show_all_guesses_textView);
        userSelectedImageView.setImageResource(userSelected);
        computerSelectedImageView.setImageResource(computerSelected);

        countDatabase = CountDatabase.getInstance(rootView.getContext());
        String progressTextViewText = getString(R.string.success_rate_textview_text) + " " + averageSuccess() + "%";
        progressTextView.setText(progressTextViewText);

        if (result) {
            resultTextView.setText(getString(R.string.correct_answer));
        } else {
            resultTextView.setText(getString(R.string.wrong_try_again));
        }
        showAllGuesses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.moveFromResultToRecyclerViewFragment();
            }
        });

        return rootView;
    }

    private String averageSuccess() {
        int a = countDatabase.getSuccessCount() * 100;
        int b = countDatabase.getProfilesCount();
        return String.valueOf(a / b);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteractionInterface) {
            listener = (FragmentInteractionInterface) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement FragmentInteractionInterface");
        }

    }
}
