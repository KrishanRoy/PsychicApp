package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;
import com.example.krishanroy.psychic_app_hw_roy_krishan.database.CountDatabase;
import com.example.krishanroy.psychic_app_hw_roy_krishan.drawables.DrawableResources;
import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;


import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {


    private static final String CHOICE_FRAGMENT_BOOLEAN_KEY = "choice fragment boolean key";
    private static final String CHOICE_FRAGMENT_INT_KEY = "choice fragment string key";
    private View rootView;
    private FragmentInteractionInterface listener;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private int imageSelected;
    private DrawableResources drawableResources;
    private Drawable userSelection;
    private Drawable computerSelection;
    CountDatabase countDatabase;

    public ChoiceFragment() {
        // Required empty public constructor
    }

    public static ChoiceFragment newInstance(int imageSelected) {
        ChoiceFragment choiceFragment = new ChoiceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CHOICE_FRAGMENT_INT_KEY, imageSelected);
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
            imageSelected = getArguments().getInt(CHOICE_FRAGMENT_INT_KEY);
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
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final View v = rootView;
        countDatabase = CountDatabase.getInstance(v.getContext());

        switch (imageSelected) {
            case 0:
                imageView1.setImageDrawable(drawableResources.getMyImageList().get(0));
                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(0);
                        checkAndAddToDataBase();
                    }
                });

                imageView2.setImageDrawable(drawableResources.getMyImageList().get(1));
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(1);
                        checkAndAddToDataBase();
                    }
                });
                imageView3.setImageDrawable(drawableResources.getMyImageList().get(2));
                imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(2);
                        checkAndAddToDataBase();
                    }
                });
                imageView4.setImageDrawable(drawableResources.getMyImageList().get(3));
                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(3);
                        checkAndAddToDataBase();
                    }
                });
                break;
            case 1:
                imageView1.setImageDrawable(drawableResources.getMyImageList().get(4));
                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(4);
                        checkAndAddToDataBase();
                    }
                });
                imageView2.setImageDrawable(drawableResources.getMyImageList().get(5));
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(5);
                        checkAndAddToDataBase();
                    }
                });
                imageView3.setImageDrawable(drawableResources.getMyImageList().get(6));
                imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(6);
                        checkAndAddToDataBase();
                    }
                });
                imageView4.setImageDrawable(drawableResources.getMyImageList().get(7));
                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(7);
                        checkAndAddToDataBase();
                    }
                });
                break;
            case 2:
                imageView1.setImageDrawable(drawableResources.getMyImageList().get(8));
                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(8);
                        checkAndAddToDataBase();
                    }
                });
                imageView2.setImageDrawable(drawableResources.getMyImageList().get(9));
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(9);
                        checkAndAddToDataBase();
                    }
                });
                imageView3.setImageDrawable(drawableResources.getMyImageList().get(10));
                imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(10);
                        checkAndAddToDataBase();
                    }
                });
                imageView4.setImageDrawable(drawableResources.getMyImageList().get(11));
                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyImageList().get(11);
                        checkAndAddToDataBase();
                    }
                });
                break;
        }
    }

    private void checkAndAddToDataBase() {
        computerSelection = drawableResources.computerSelected();
        Log.d(TAG, "user selection : " + userSelection + "  computer selection " + computerSelection);
        if (drawableResources.perfectMatch(userSelection, computerSelection)) {
            listener.moveFromChoiceToResultFragment(true);
            countDatabase.addSelections(new TrackAverage(userSelection, computerSelection, 1));
        } else {
            listener.moveFromChoiceToResultFragment(false);
            countDatabase.addSelections(new TrackAverage(userSelection, computerSelection, 0));
        }
    }
}
