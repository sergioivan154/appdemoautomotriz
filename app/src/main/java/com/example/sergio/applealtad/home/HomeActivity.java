package com.example.sergio.applealtad.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.home.secciones.DirectorioFragment;
import com.example.sergio.applealtad.home.secciones.HomeFragment;
import com.example.sergio.applealtad.home.secciones.ManualEmergenciaFragment;
import com.example.sergio.applealtad.home.secciones.PromocionesFragment;
import com.example.sergio.applealtad.home.secciones.RefaccionesFragment;
import com.example.sergio.applealtad.home.secciones.SeminuevoFragment;
import com.example.sergio.applealtad.home.secciones.ServicioFragment;
import com.example.sergio.applealtad.home.secciones.TipsFragment;
import com.example.sergio.applealtad.register.RegisterFragment;
import com.google.android.gms.maps.model.LatLng;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,fab3,fab4;
    TextView txtFab1,txtFab2,txtFab3,txtFab4;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.content_home, HomeFragment.getInstance());
        ft.commit();


    }
    @Override
    public void onBackPressed() {

        int index = getSupportFragmentManager().getBackStackEntryCount();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(index>0) {
            super.onBackPressed();
        }



    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_promos) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_home, PromocionesFragment.getInstance());
            ft.commit();
        }
        else if (id == R.id.nav_home) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_home, HomeFragment.getInstance());
            ft.commit();
        }
        else if (id == R.id.nav_refac) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_home, RefaccionesFragment.getInstance());
            ft.commit();

        } else if (id == R.id.nav_service) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_home, ServicioFragment.getInstance());
            ft.commit();

        } else if (id == R.id.nav_manual) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_home, ManualEmergenciaFragment.getInstance());
            ft.commit();

        } else if (id == R.id.nav_seminuevo) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, SeminuevoFragment.getInstance());
            ft.commit();


        } else if (id == R.id.nav_directorio) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, DirectorioFragment.getInstance());
            ft.commit();
        }else  if(id == R.id.nav_tips){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, TipsFragment.getInstance());
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
