package com.example.navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class LandingPageFragment extends Fragment {

    private Button mButton;

    public LandingPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_landing_page, container, false);
        mButton = v.findViewById(R.id.button_next);
        mButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_landing_page_frag_to_room_frag,
                        null));
        return v;
    }

}
