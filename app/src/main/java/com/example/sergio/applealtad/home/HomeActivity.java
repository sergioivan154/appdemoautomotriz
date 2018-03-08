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
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener  {

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

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab4 = (FloatingActionButton)findViewById(R.id.fab4);
        fab3 = (FloatingActionButton)findViewById(R.id.fab3);
        fab_open = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab3.setOnClickListener(this);
        txtFab1 = (TextView)findViewById(R.id.txtfab1);
        txtFab4 = (TextView)findViewById(R.id.txtfab4);
        txtFab3 = (TextView)findViewById(R.id.txtfab3);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){
            case R.id.fab:

                animateFAB();

                break;
            case R.id.fab1:


                break;

            case R.id.fab3:



                break;

            case R.id.fab4:

                break;
        }

    }
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab1.setClickable(false);
            fab4.setClickable(false);
            fab3.setClickable(false);
            txtFab1.startAnimation(fab_close);
            txtFab1.setVisibility(View.INVISIBLE);
            txtFab4.startAnimation(fab_close);
            txtFab4.setVisibility(View.INVISIBLE);
            txtFab3.startAnimation(fab_close);
            txtFab3.setVisibility(View.INVISIBLE);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab1.setClickable(true);
            fab4.setClickable(true);
            fab3.setClickable(true);
            txtFab1.startAnimation(fab_open);
            txtFab4.startAnimation(fab_open);
            txtFab3.startAnimation(fab_open);
            txtFab1.setVisibility(View.VISIBLE);
            txtFab4.setVisibility(View.VISIBLE);
            txtFab3.setVisibility(View.VISIBLE);
            isFabOpen = true;
            Log.d("Raj","open");

        }
    }
}
