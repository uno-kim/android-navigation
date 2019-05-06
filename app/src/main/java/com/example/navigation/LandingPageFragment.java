package com.example.navigation;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigation.dashboard.DashboardFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class LandingPageFragment extends Fragment implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "LandingPageFragment";

    private CoordinatorLayout mCoordinatorLayout;
    private DrawerLayout mDrawerLayout;
    private DashboardFragment mDashboardFragment;

    public LandingPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView()");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_landing_page, container, false);
        AppBarLayout appBarLayout = v.findViewById(R.id.appbar_layout);
        Toolbar toolbar = (Toolbar) inflater.inflate(R.layout.landing_page_action_bar, appBarLayout,
                false);
        toolbar.setTitle("Hello");
        appBarLayout.addView(toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
        mDrawerLayout = v.findViewById(R.id.drawer_layout);
        NavigationView navigationView = v.findViewById(R.id.nav_view);
        mCoordinatorLayout = v.findViewById(R.id.main_landing_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), mDrawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                mCoordinatorLayout.setTranslationX(slideX);
            }
        };
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mDashboardFragment = new DashboardFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.dashboard_container, mDashboardFragment).commit();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
