package com.golduba.n;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class DrawerFragment extends Fragment {

    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    NavigationView drawerNavItems;
    TextView drawer_header_title;
    View headerView;
    ImageView drawer_imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View drawerView = inflater.inflate(R.layout.fragment_drawer, container, false);

        drawerLayout = drawerView.findViewById(R.id.drawerLayout);
        materialToolbar =drawerView.findViewById(R.id.materialToolbar);
        drawerNavItems = drawerView.findViewById(R.id.drawerNavItems);
        headerView = drawerNavItems.getHeaderView(0);
        drawer_header_title = headerView.findViewById(R.id.drawer_header_title);  drawer_imageView = headerView.findViewById(R.id.drawer_imageView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawerLayout,materialToolbar,R.string.drawer_close,R.string.drawer_open);
        drawerLayout.addDrawerListener(toggle);

        //-----------------------------------------------------------------------------

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId()==R.id.share){

                    Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });


        //---------------------------------Drawer Nav------------------------------------------------
        drawerNavItems.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.nav_item_home){

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.home_frameLayout, new HomeFragment());
                    fragmentTransaction.commit();

                    //Toast.makeText(getContext(), "Home", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId()==R.id.nav_recent){
                    Toast.makeText(getContext(), "Recent", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);

                }
                else if (item.getItemId()==R.id.nav_pinned){
                    Toast.makeText(getContext(), "Pinned", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId()==R.id.nav_review){
                    Toast.makeText(getContext(), "Review", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId()==R.id.nev_exit){
                    Toast.makeText(getContext(), "Exit", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }


                return true;
            }
        });


        //------------------------------------------------------------------------------------------


       return drawerView;
    }
}