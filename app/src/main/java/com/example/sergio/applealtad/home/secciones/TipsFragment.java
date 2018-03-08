package com.example.sergio.applealtad.home.secciones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterRefac;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterTips;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends BaseFragment {


    public static TipsFragment getInstance() {
        TipsFragment fragment=new TipsFragment();
        return fragment;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        List<Integer> imgTips = new ArrayList<>();
        List<String> txtTips = new ArrayList<>();

        imgTips.add(R.drawable.tips01);
        imgTips.add(R.drawable.tips02);
        imgTips.add(R.drawable.tips03);
        imgTips.add(R.drawable.tips04);
        txtTips.add("1. Recuerda que los menores de 18 años, deben manejar acompañados de un adulto.");
        txtTips.add("2. Cuando escuches una sirena, reduce tu velocidad y oríllate a la derecha.");
        txtTips.add("3. Las velocidades permitidas son: en escuelas 20 km/h, en zona habitacional 30 km/h, en calles 40 km/h y en avenidas 50 km/h ");
        txtTips.add("4. Evita conducir cansado y sobretodo en las madrugadas (entre 2:00 y 5:00 am)");




        AdapterTips adapterTips = new AdapterTips(getContext(),imgTips,txtTips);
        RecyclerView rwTips = (RecyclerView)findViewById(R.id.rwTips);
        rwTips.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwTips.setAdapter(adapterTips);
        adapterTips.notifyDataSetChanged();


    }
}
