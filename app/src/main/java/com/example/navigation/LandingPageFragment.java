package com.example.navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navigation.dashboard.DashboardAdapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 20; ++i) {
            list.add("Item number " + i);
        }
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DashboardAdapter adapter = new DashboardAdapter(list);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
