package com.example.sergio.applealtad.home.secciones;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergio.applealtad.Entities.DirectorioPojo;
import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterDirectorio;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterSeminuevo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DirectorioFragment extends BaseFragment  implements OnMapReadyCallback, LocationListener, GoogleMap.OnInfoWindowClickListener {


    private static final long MIN_TIME = 400;
    private GoogleMap mapa;
    private LocationManager locationManager;
    private static final float MIN_DISTANCE = 1000;
    private LatLng latLng;

    public static DirectorioFragment getInstance(){
        DirectorioFragment fragment=new DirectorioFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_directorio, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return view;
        }

        LocationManager locManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean isEnableGPS = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isEnableNTW = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Log.d("location :", isEnableGPS + ", " + isEnableNTW);


        if (isEnableNTW) {

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, (android.location.LocationListener) this); //You can also use LocationManager.GPS_PROVIDER and LocationManager.PASSIVE_PROVIDER

        } else if (isEnableGPS) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, (android.location.LocationListener) this);

        } else {
            getActivity().startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));

        }


        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<DirectorioPojo> lDirectorio = new ArrayList<>();
        lDirectorio.add(new DirectorioPojo("Aseguradora", "01 (55) 47495114"));
        lDirectorio.add(new DirectorioPojo("Financiera", " 01 800 2020 680"));
        lDirectorio.add(new DirectorioPojo("Policia", "911"));
        lDirectorio.add(new DirectorioPojo("Bomberos", "911"));

        AdapterDirectorio adapterDirectorio = new AdapterDirectorio(getContext(),lDirectorio);

        RecyclerView rwDirectorio = (RecyclerView)findViewById(R.id.rvDirectorio);
        rwDirectorio.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwDirectorio.setAdapter(adapterDirectorio);
        adapterDirectorio.notifyDataSetChanged();


    }

    @Override
    public void onLocationChanged(Location location) {
        try {
          /*  latLng = new LatLng(location.getLatitude(), location.getLongitude());
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
            mapa.animateCamera(cameraUpdate);
            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }*/
            //locationManager.removeUpdates(DirectorioFragment.this);
        }
        catch (Exception ex){
            Log.i("Excepcion controlada", ex.getMessage());
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapReady(GoogleMap map) {
        boolean permisos = false;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permisos = checkLocationPermission();
        }



        if (permisos) {

            //map.setMyLocationEnabled(true);
            mapa = map;

          /*  for(LatLng posicion:lPosiciones) {
                BitmapFactory.Options opt = new BitmapFactory.Options();
                opt.inMutable = true;

                Bitmap imageBitmap= BitmapFactory.decodeResource(getResources(),
                        R.drawable.marker,opt);

                map.addMarker(new MarkerOptions()
                        .position(posicion)


                )
                        .setIcon(BitmapDescriptorFactory.fromBitmap(imageBitmap))
                ;


            }*/

         //   map.setOnInfoWindowClickListener(this);

            // Set the map type back to normal.
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            Location  location = null;
            double lat = 18.948560;
            double lng =  -99.244370;
            /*if (locationManager != null) {
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (location != null) {
                    lat = location.getLatitude();
                    lng = location.getLongitude();
                }
            }*/
            latLng = new LatLng(lat, lng);

            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inMutable = true;

          /*  Bitmap imageBitmap= BitmapFactory.decodeResource(getResources(),
                    R.drawable.cliente,opt);*/

            map.addMarker(new MarkerOptions().position(latLng));//.setIcon(BitmapDescriptorFactory.fromBitmap(imageBitmap));
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
            mapa.animateCamera(cameraUpdate);

        }
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //  TODO: Prompt with explanation!

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

}
