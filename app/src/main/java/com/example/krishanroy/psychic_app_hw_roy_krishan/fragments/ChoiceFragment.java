package com.example.krishanroy.psychic_app_hw_roy_krishan.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.krishanroy.psychic_app_hw_roy_krishan.R;
import com.example.krishanroy.psychic_app_hw_roy_krishan.database.CountDatabase;
import com.example.krishanroy.psychic_app_hw_roy_krishan.drawables.DrawableResources;
import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;

public class ChoiceFragment extends Fragment {

    private static final String CHOICE_FRAGMENT_INT_KEY = "choice fragment string key";
    private View rootView;
    private FragmentInteractionInterface listener;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private int imageSelected;
    private DrawableResources drawableResources;
    private int userSelection;
    private int computerSelection;
    CountDatabase countDatabase;
    private ImageView[] imageViews;

    public ChoiceFragment() {
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
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_choice, container, false);
        imageView1 = rootView.findViewById(R.id.imageView1);
        imageView2 = rootView.findViewById(R.id.imageView2);
        imageView3 = rootView.findViewById(R.id.imageView3);
        imageView4 = rootView.findViewById(R.id.imageView4);
        imageViews = new ImageView[]{imageView1, imageView2, imageView3, imageView4};
        drawableResources = DrawableResources.getDrawableResources();
        drawableResources.saveImagestoList();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final View v = rootView;
        countDatabase = CountDatabase.getInstance(v.getContext());

        switch (imageSelected) {
            case 0:
                imageViews[0].setImageResource(drawableResources.getMyBoatImageList().get(0));
                imageViews[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyBoatImageList().get(0);
                        computerSelection = drawableResources.computerBoatSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[1].setImageResource(drawableResources.getMyBoatImageList().get(1));
                imageViews[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyBoatImageList().get(1);
                        computerSelection = drawableResources.computerBoatSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[2].setImageResource(drawableResources.getMyBoatImageList().get(2));
                imageViews[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyBoatImageList().get(2);
                        computerSelection = drawableResources.computerBoatSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[3].setImageResource(drawableResources.getMyBoatImageList().get(3));
                imageViews[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyBoatImageList().get(3);
                        computerSelection = drawableResources.computerBoatSelected();
                        checkAndAddToDataBase();
                    }
                });

                break;
            case 1:
                imageViews[0].setImageResource(drawableResources.getMyForestImageList().get(0));
                imageViews[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyForestImageList().get(0);
                        computerSelection = drawableResources.computerForestSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[1].setImageResource(drawableResources.getMyForestImageList().get(1));
                imageViews[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyForestImageList().get(1);
                        computerSelection = drawableResources.computerForestSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[2].setImageResource(drawableResources.getMyForestImageList().get(2));
                imageViews[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyForestImageList().get(2);
                        computerSelection = drawableResources.computerForestSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[3].setImageResource(drawableResources.getMyForestImageList().get(3));
                imageViews[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyForestImageList().get(3);
                        computerSelection = drawableResources.computerForestSelected();
                        checkAndAddToDataBase();
                    }
                });
                break;
            case 2:
                imageViews[0].setImageResource(drawableResources.getMyLakeImageList().get(0));
                imageViews[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyLakeImageList().get(0);
                        computerSelection = drawableResources.computerLakeSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[1].setImageResource(drawableResources.getMyLakeImageList().get(1));
                imageViews[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyLakeImageList().get(1);
                        computerSelection = drawableResources.computerLakeSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[2].setImageResource(drawableResources.getMyLakeImageList().get(2));
                imageViews[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyLakeImageList().get(2);
                        computerSelection = drawableResources.computerLakeSelected();
                        checkAndAddToDataBase();
                    }
                });
                imageViews[3].setImageResource(drawableResources.getMyLakeImageList().get(3));
                imageViews[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSelection = drawableResources.getMyLakeImageList().get(3);
                        computerSelection = drawableResources.computerLakeSelected();
                        checkAndAddToDataBase();
                    }
                });
                break;
        }
    }

    private void checkAndAddToDataBase() {
        if (drawableResources.perfectMatch(userSelection, computerSelection)) {
            listener.moveFromChoiceToResultFragment(true, userSelection, computerSelection);
            countDatabase.addSelections(new TrackAverage(userSelection, computerSelection, 1));
        } else {
            listener.moveFromChoiceToResultFragment(false, userSelection, computerSelection);
            countDatabase.addSelections(new TrackAverage(userSelection, computerSelection, 0));
        }
    }
}
