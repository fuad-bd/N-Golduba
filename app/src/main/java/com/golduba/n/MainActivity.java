package com.golduba.n;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.golduba.n.BottomNavigation;
import com.golduba.n.HomeFragment;
import com.golduba.n.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout bottomNavframeLayout, home_frameLayout;
    DrawerLayout drawerLayout;
    NavigationView drawerNavItems;
    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerNavItems = findViewById(R.id.drawerNavItems);
        materialToolbar = findViewById(R.id.materialToolbar);
        bottomNavframeLayout = findViewById(R.id.bottomNavframeLayout);
        home_frameLayout = findViewById(R.id.home_frameLayout);

        // Set up the toolbar
        setSupportActionBar(materialToolbar);

        // Add Home Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_frameLayout, new HomeFragment())
                .commit();

        // Add Bottom Navigation Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.bottomNavframeLayout, new BottomNavigation())
                .commit();

        // Setup Drawer Toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, materialToolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle Navigation Item Clicks
        drawerNavItems.setNavigationItemSelectedListener(item -> {
            // Handle drawer item clicks here
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}