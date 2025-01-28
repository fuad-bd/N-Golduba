package com.golduba.n;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class DrawerNavigation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View drawerNavigation = inflater.inflate(R.layout.fragment_drawer_navigation, container, false);

        //---------------------------------Drawer Nav------------------------------------------------
/*
        DrawerLayout drawerLayout;
        MaterialToolbar materialToolbar;
        FrameLayout frameLayout;
        NavigationView navigationView;

        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawerLayout,materialToolbar,R.string.drawer_close,R.string.drawer_open);

        drawerLayout.addDrawerListener(toggle);
*/

        //------------------------------------------------------------------------------------------
        return drawerNavigation;
    }
}