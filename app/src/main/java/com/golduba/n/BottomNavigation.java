package com.golduba.n;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class BottomNavigation extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentBottomNavigation = inflater.inflate(R.layout.fragment_bottom_navigation, container, false);


        //----------------------------------Bottom Nav-----------------------------------------------

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = fragmentBottomNavigation.findViewById(R.id.bottomNavigation);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Handle Home button click
                if (item.getItemId() == R.id.menu_home) {

                   getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frameLayout,
                           new HomeFragment()).commit();
                }
                // Handle Notification button click
                else if (item.getItemId() == R.id.menu_notification) {
                    Toast.makeText(getContext(), "Notifications clicked", Toast.LENGTH_SHORT).show();
                }
                // Handle Profile button click
                else if (item.getItemId() == R.id.menu_profile) {
                    Toast.makeText(getContext(), "Profile clicked", Toast.LENGTH_SHORT).show();
                }
                // Handle Search button click
                else if (item.getItemId() == R.id.menu_search) {
                    Toast.makeText(getContext(), "Search clicked", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });

        return fragmentBottomNavigation;
    }
}