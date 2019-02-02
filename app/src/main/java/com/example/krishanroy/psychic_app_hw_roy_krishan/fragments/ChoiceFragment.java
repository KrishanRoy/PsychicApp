package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;
import com.example.krishanroy.psychic_app_hw_roy_krishan.database.DrawableResources;


import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {


    private static final String CHOICE_FRAGMENT_BOOLEAN_KEY = "choice fragment boolean key";
    private View rootView;
    private FragmentInteractionInterface listener;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private int spinnerSelection;
    private int imageSelected;
    private DrawableResources drawableResources;

    public ChoiceFragment() {
        // Required empty public constructor
    }

    public static ChoiceFragment newInstance(boolean isSelectionMatched) {
        ChoiceFragment choiceFragment = new ChoiceFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(CHOICE_FRAGMENT_BOOLEAN_KEY, isSelectionMatched);
        choiceFragment.setArguments(bundle);
        return choiceFragment;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageSelected = getArguments().getInt(CHOICE_FRAGMENT_BOOLEAN_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_choice, container, false);
        imageView1 = rootView.findViewById(R.id.choice_first_imageview);
        imageView2 = rootView.findViewById(R.id.choice_second_imageview);
        imageView3 = rootView.findViewById(R.id.choice_third_imageview);
        imageView4 = rootView.findViewById(R.id.choice_fourth_imageview);

        drawableResources = new DrawableResources(rootView.getContext());
        drawableResources.saveImagestoList();

        if (getArguments() != null && getArguments().containsKey(MainFragment.MAIN_FRAGMENT_INT_KEY)) {
            spinnerSelection = getArguments().getInt(MainFragment.MAIN_FRAGMENT_INT_KEY);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final View v = rootView;
        int userSelection = 0;
        int trackNumbersOfSuccess = 0;
        int trackNumbersOfSelectionsMade = 0;
        int computerSelection = drawableResources.computerSelected();
        switch (spinnerSelection) {
            case 0:
                imageView1.setImageDrawable(drawableResources.getMyImageList().get(0));
                imageView2.setImageDrawable(drawableResources.getMyImageList().get(1));
                imageView3.setImageDrawable(drawableResources.getMyImageList().get(2));
                imageView4.setImageDrawable(drawableResources.getMyImageList().get(3));
                break;
            case 1:
                imageView1.setImageDrawable(drawableResources.getMyImageList().get(4));
                imageView2.setImageDrawable(drawableResources.getMyImageList().get(5));
                imageView3.setImageDrawable(drawableResources.getMyImageList().get(6));
                imageView4.setImageDrawable(drawableResources.getMyImageList().get(7));
                break;
            case 2:
                imageView1.setImageDrawable(drawableResources.getMyImageList().get(8));
                imageView2.setImageDrawable(drawableResources.getMyImageList().get(9));
                imageView3.setImageDrawable(drawableResources.getMyImageList().get(10));
                imageView4.setImageDrawable(drawableResources.getMyImageList().get(11));
                break;
        }
        if (drawableResources.perfectMatch(userSelection, computerSelection)) {
            //listener.moveFromChoiceToResultFragment(true);
            trackNumbersOfSuccess++;
        } else {
            //listener.moveFromChoiceToResultFragment(false);
        }
    }
}
